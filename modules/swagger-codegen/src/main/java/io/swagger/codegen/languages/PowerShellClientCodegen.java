package io.swagger.codegen.languages;

import io.swagger.codegen.*;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PowerShellClientCodegen extends DefaultCodegen implements CodegenConfig {
    static Logger LOGGER = LoggerFactory.getLogger(PowerShellClientCodegen.class);
/*
    protected String groupId = "io.swagger";
    protected String artifactId = "kotlin-client";
    protected String artifactVersion = "1.0.0";
*/
    protected String sourceFolder = "src";
    protected String packageName = "IO.Swagger";
    protected String apiDocPath = "docs/";
    protected String modelDocPath = "docs/";

    /**
     * Constructs an instance of `PowerShellClientCodegen`.
     */
    public PowerShellClientCodegen() {
        super();

        outputFolder = "generated-code" + File.separator + "powershell";
        modelTemplateFiles.put("model.mustache", ".ps1");
        apiTemplateFiles.put("api.mustache", ".ps1");
        modelDocTemplateFiles.put("model_doc.mustache", ".md");
        apiDocTemplateFiles.put("api_doc.mustache", ".md");
        embeddedTemplateDir = templateDir = "powershell";
        apiPackage = packageName + File.separator + "API";
        modelPackage = packageName + File.separator + "Model";

        // https://blogs.msdn.microsoft.com/powershell/2010/01/07/how-objects-are-sent-to-and-from-remote-sessions/
        languageSpecificPrimitives = new HashSet<String>(Arrays.asList(
                "Byte",
                "SByte",
                "Byte[]",
                "Int16",
                "Int32",
                "Int64",
                "UInt16",
                "UInt32",
                "UInt64",
                "Decimal",
                "Single",
                "Double",
                "TimeSpan",
                "System.DateTime",
                "ProgressRecord",
                "Char",
                "String",
                "XmlDocument",
                "SecureString",
                "Boolean",
                "Guid",
                "Uri",
                "Version"
        ));

        // https://richardspowershellblog.wordpress.com/2009/05/02/powershell-reserved-words/
        reservedWords = new HashSet<String>(Arrays.asList(
                "Begin",
                "Break",
                "Catch",
                "Continue",
                "Data",
                "Do",
                "Dynamicparam",
                "Else",
                "Elseif",
                "End",
                "Exit",
                "Filter",
                "Finally",
                "For",
                "Foreach",
                "From",
                "Function",
                "If",
                "In",
                "Param",
                "Process",
                "Return",
                "Switch",
                "Throw",
                "Trap",
                "Try",
                "Until",
                "While",
                "Local",
                "Private",
                "Where"
        ));


        defaultIncludes = new HashSet<String>(Arrays.asList(
                "Byte",
                "SByte",
                "Byte[]",
                "Int16",
                "Int32",
                "Int64",
                "UInt16",
                "UInt32",
                "UInt64",
                "Decimal",
                "Single",
                "Double",
                "TimeSpan",
                "DateTime",
                "ProgressRecord",
                "Char",
                "String",
                "XmlDocument",
                "SecureString",
                "Boolean",
                "Guid",
                "Uri",
                "Version"
        ));

        typeMapping = new HashMap<String, String>();
        typeMapping.put("string", "String");
        typeMapping.put("boolean", "Boolean");
        typeMapping.put("integer", "Int32");
        typeMapping.put("float", "Double");
        typeMapping.put("long", "Int64");
        typeMapping.put("double", "Double");
        typeMapping.put("number", "Decimal");
        typeMapping.put("date-time", "System.DateTime");
        typeMapping.put("date", "System.DateTime");
        typeMapping.put("file", "String");
        //typeMapping.put("array", "collections.List");
        //typeMapping.put("list", "collections.List");
        //typeMapping.put("map", "collections.Map");
        typeMapping.put("object", "String");
        typeMapping.put("binary", "String");
        typeMapping.put("Date", "System.DateTime");
        typeMapping.put("DateTime", "System.DateTime");

        //instantiationTypes.put("array", "listOf");
        //instantiationTypes.put("list", "listOf");
        //instantiationTypes.put("map", "mapOf");

        /*importMapping = new HashMap<String, String>();
        importMapping.put("BigDecimal", "java.math.BigDecimal");
        importMapping.put("UUID", "java.util.UUID");
        importMapping.put("File", "java.io.File");
        importMapping.put("Date", "java.util.Date");
        importMapping.put("Timestamp", "java.sql.Timestamp");
        importMapping.put("DateTime", "java.time.LocalDateTime");
        importMapping.put("LocalDateTime", "java.time.LocalDateTime");
        importMapping.put("LocalDate", "java.time.LocalDate");
        importMapping.put("LocalTime", "java.time.LocalTime");*/

        cliOptions.clear();
        cliOptions.add(new CliOption(CodegenConstants.PACKAGE_NAME, "Client package name (e.g. io.swagger.client).").defaultValue(this.packageName));
        //cliOptions.add(new CliOption(CodegenConstants.GROUP_ID, "Client package's organization (i.e. maven groupId).").defaultValue(groupId));
        //cliOptions.add(new CliOption(CodegenConstants.ARTIFACT_ID, "Client artifact id (name of generated jar).").defaultValue(artifactId));
        //cliOptions.add(new CliOption(CodegenConstants.ARTIFACT_VERSION, "Client package version.").defaultValue(artifactVersion));
    }

    public CodegenType getTag() {
        return CodegenType.CLIENT;
    }

    public String getName() {
        return "powershell";
    }

    public String getHelp() {
        return "Generates a PowerShell client.";
    }
/*
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public void setArtifactVersion(String artifactVersion) {
        this.artifactVersion = artifactVersion;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
*/
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = sourceFolder;
    }

    @Override
    public void processOpts() {
        super.processOpts();

        if (additionalProperties.containsKey(CodegenConstants.PACKAGE_NAME)) {
            this.setPackageName((String) additionalProperties.get(CodegenConstants.PACKAGE_NAME));
        } else {
            additionalProperties.put(CodegenConstants.PACKAGE_NAME, packageName);
        }
/*
        if(additionalProperties.containsKey(CodegenConstants.ARTIFACT_ID)) {
            this.setArtifactId((String) additionalProperties.get(CodegenConstants.ARTIFACT_ID));
        } else {
            additionalProperties.put(CodegenConstants.ARTIFACT_ID, artifactId);
        }

        if(additionalProperties.containsKey(CodegenConstants.GROUP_ID)) {
            this.setGroupId((String) additionalProperties.get(CodegenConstants.GROUP_ID));
        } else {
            additionalProperties.put(CodegenConstants.GROUP_ID, groupId);
        }

        if(additionalProperties.containsKey(CodegenConstants.ARTIFACT_VERSION)) {
            this.setArtifactVersion((String) additionalProperties.get(CodegenConstants.ARTIFACT_VERSION));
        } else {
            additionalProperties.put(CodegenConstants.ARTIFACT_VERSION, artifactVersion);
        }

        if (additionalProperties.containsKey(CodegenConstants.INVOKER_PACKAGE)) {
            LOGGER.warn(CodegenConstants.INVOKER_PACKAGE + " with " + this.getName() + " generator is ignored. Use " + CodegenConstants.PACKAGE_NAME + ".");
        }
*/
        if (additionalProperties.containsKey(CodegenConstants.MODEL_PACKAGE)) {
            LOGGER.warn(CodegenConstants.MODEL_PACKAGE + " with " + this.getName() + " generator is ignored. Setting this value independently of " + CodegenConstants.PACKAGE_NAME + " is not currently supported.");
        }

        if (additionalProperties.containsKey(CodegenConstants.API_PACKAGE)) {
            LOGGER.warn(CodegenConstants.API_PACKAGE + " with " + this.getName() + " generator is ignored. Setting this value independently of " + CodegenConstants.PACKAGE_NAME + " is not currently supported.");
        }

        additionalProperties.put(CodegenConstants.API_PACKAGE, apiPackage());
        additionalProperties.put(CodegenConstants.MODEL_PACKAGE, modelPackage());

        additionalProperties.put("apiDocPath", apiDocPath);
        additionalProperties.put("modelDocPath", modelDocPath);

        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
        supportingFiles.add(new SupportingFile("Build.ps1.mustache", "", "Build.ps1"));

        final String infrastructureFolder = (sourceFolder + File.separator + packageName + File.separator);

        supportingFiles.add(new SupportingFile("IO.Swagger.psm1.mustache", infrastructureFolder, packageName + ".psm1"));

        // private
        supportingFiles.add(new SupportingFile("Get-CommonParameters.ps1", infrastructureFolder + File.separator + "Private" + File.separator, "Get-CommonParameters.ps1"));
        supportingFiles.add(new SupportingFile("Out-DebugParameter.ps1", infrastructureFolder + File.separator + "Private" + File.separator, "Out-DebugParameter.ps1"));

        // en-US
        supportingFiles.add(new SupportingFile("about_IO.Swagger.help.txt.mustache", infrastructureFolder + File.separator + "en-US" + File.separator + "about_" + packageName + ".help.txt"));

/*
        supportingFiles.add(new SupportingFile("infrastructure/ApiClient.kt.mustache", infrastructureFolder, "ApiClient.kt"));
        supportingFiles.add(new SupportingFile("infrastructure/ApiInfrastructureResponse.kt.mustache", infrastructureFolder, "ApiInfrastructureResponse.kt"));
        supportingFiles.add(new SupportingFile("infrastructure/ApplicationDelegates.kt.mustache", infrastructureFolder, "ApplicationDelegates.kt"));
        supportingFiles.add(new SupportingFile("infrastructure/RequestConfig.kt.mustache", infrastructureFolder, "RequestConfig.kt"));
        supportingFiles.add(new SupportingFile("infrastructure/RequestMethod.kt.mustache", infrastructureFolder, "RequestMethod.kt"));
        supportingFiles.add(new SupportingFile("infrastructure/ResponseExtensions.kt.mustache", infrastructureFolder, "ResponseExtensions.kt"));
        supportingFiles.add(new SupportingFile("infrastructure/Serializer.kt.mustache", infrastructureFolder, "Serializer.kt"));
        supportingFiles.add(new SupportingFile("infrastructure/Errors.kt.mustache", infrastructureFolder, "Errors.kt"));
*/
    }

    @Override
    public String escapeUnsafeCharacters(String input) {
        return input.replace("#>", "#_>").replace("<#", "<_#");
    }

    @Override
    public String escapeQuotationMark(String input) {
        // remove " to avoid code injection
        return input.replace("\"", "");
    }

    @Override
    public String apiDocFileFolder() {
        return (outputFolder + "/" + apiDocPath).replace('/', File.separatorChar);
    }

    @Override
    public String apiFileFolder() {
        return outputFolder + File.separator + sourceFolder + File.separator + apiPackage();
    }

    @Override
    public String modelDocFileFolder() {
        return (outputFolder + "/" + modelDocPath).replace('/', File.separatorChar);
    }


    @Override
    public String modelFileFolder() {
        return outputFolder + File.separator + sourceFolder + File.separator + modelPackage();
    }

    @Override
    public String escapeReservedWord(String name) {
        return "_" + name;
    }

    /**
     * Output the proper model name (capitalized).
     * In case the name belongs to the TypeSystem it won't be renamed.
     *
     * @param name the name of the model
     * @return capitalized model name
     */
    @Override
    public String toModelName(String name) {
        if (!StringUtils.isEmpty(modelNamePrefix)) {
            name = modelNamePrefix + "_" + name;
        }

        if (!StringUtils.isEmpty(modelNameSuffix)) {
            name = name + "_" + modelNameSuffix;
        }

        name = sanitizeName(name);

        // model name cannot use reserved keyword, e.g. return
        if (isReservedWord(name)) {
            LOGGER.warn(name + " (reserved word) cannot be used as model name. Renamed to " + camelize("model_" + name));
            name = "model_" + name; // e.g. return => ModelReturn (after camelize)
        }

        // model name starts with number
        if (name.matches("^\\d.*")) {
            LOGGER.warn(name + " (model name starts with number) cannot be used as model name. Renamed to " + camelize("model_" + name));
            name = "model_" + name; // e.g. 200Response => Model200Response (after camelize)
        }

        // camelize the model name
        // phone_number => PhoneNumber
        return camelize(name);
    }

    @Override
    public String toModelFilename(String name) {
        // should be the same as the model name
        return "New-" + toModelName(name);
    }

    /**
     * returns the swagger type for the property
     *
     * @param p Swagger property object
     * @return string presentation of the type
     **/
    @Override
    public String getSwaggerType(Property p) {
        String swaggerType = super.getSwaggerType(p);
        String type;
        // This maps, for example, long -> Long based on hashes in this type's constructor
        if (typeMapping.containsKey(swaggerType)) {
            type = typeMapping.get(swaggerType);
            if (languageSpecificPrimitives.contains(type)) {
                return type;
            }
        } else  {
            type = swaggerType;
        }

        // model/object
        return toModelName(type);
    }

    /**
     * Output the type declaration of the property
     *
     * @param p Swagger Property object
     * @return a string presentation of the property type
     */
    @Override
    public String getTypeDeclaration(Property p) {
        if (p instanceof ArrayProperty) {
            ArrayProperty ap = (ArrayProperty) p;
            Property inner = ap.getItems();
            return getTypeDeclaration(inner);
        } else if (p instanceof MapProperty) {
            MapProperty mp = (MapProperty) p;
            Property inner = mp.getAdditionalProperties();
            // TODO not sure if the following map/hash declaration is correct
            return "{String, " + getTypeDeclaration(inner) + "}";
        } else if (!languageSpecificPrimitives.contains(typeMapping.get(super.getSwaggerType(p)))) {
            return packageName + ".Model." + super.getTypeDeclaration(p);

        }
        return super.getTypeDeclaration(p);
    }

    @Override
    public String toOperationId(String operationId) {
        // throw exception if method name is empty (should not occur as an auto-generated method name will be used)
        if (StringUtils.isEmpty(operationId)) {
            throw new RuntimeException("Empty method name (operationId) not allowed");
        }

        // method name cannot use reserved keyword, e.g. return
        if (isReservedWord(operationId)) {
            LOGGER.warn(operationId + " (reserved word) cannot be used as method name. Renamed to " + camelize(sanitizeName("call_" + operationId)));
            operationId = "call_" + operationId;
        }

        return camelize(sanitizeName(operationId));
    }

}
