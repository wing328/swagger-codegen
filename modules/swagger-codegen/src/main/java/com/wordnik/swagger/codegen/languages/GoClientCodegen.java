package com.wordnik.swagger.codegen.languages;

import com.wordnik.swagger.codegen.*;
import com.wordnik.swagger.models.properties.*;

import java.util.*;
import java.io.File;

public class GoClientCodegen extends DefaultCodegen implements CodegenConfig {
  protected String invokerPackage = "swagger";
  protected String groupId = "io.swagger";
  protected String artifactId = "swagger-go-client";
  protected String artifactVersion = "1.0.0";

  public CodegenType getTag() {
    return CodegenType.CLIENT;
  }

  public String getName() {
    return "go";
  }

  public String getHelp() {
    return "Generates a Go client library.";
  }

  public GoClientCodegen() {
    super();
    outputFolder = "generated-code/go";
    modelTemplateFiles.put("model.mustache", ".go");
    apiTemplateFiles.put("api.mustache", ".go");
    templateDir = "go";
    apiPackage = "io.swagger.client.api";
    modelPackage = "io.swagger.client.model";

    reservedWords = new HashSet<String> (
      Arrays.asList(
        "abstract", "continue", "for", "new", "switch", "assert", 
        "default", "if", "package", "synchronized", "boolean", "do", "goto", "private", 
        "this", "break", "double", "implements", "protected", "throw", "byte", "else", 
        "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", 
        "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", 
        "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", 
        "native", "super", "while")
    );

    additionalProperties.put("invokerPackage", invokerPackage);
    additionalProperties.put("groupId", groupId);
    additionalProperties.put("artifactId", artifactId);
    additionalProperties.put("artifactVersion", artifactVersion);

    supportingFiles.add(new SupportingFile("apiInvoker.mustache", 
      "", "ApiInvoker.go"));
    supportingFiles.add(new SupportingFile("apiException.mustache", 
      "", "ApiException.go"));

    languageSpecificPrimitives = new HashSet<String>(
      Arrays.asList(
        "string",
        "bool",
        "int32",
        "int64",
        "float32",
        "float64",
        "Object")
      );
    instantiationTypes.put("array", "ArrayLislt");
    instantiationTypes.put("map", "HashMap");

    typeMapping.clear();
    typeMapping.put("integer", "int32");
    typeMapping.put("long", "int64");
    typeMapping.put("float", "float32");
    typeMapping.put("double", "float64");
    typeMapping.put("boolean", "bool");
    typeMapping.put("string", "string");
    typeMapping.put("date", "Time");
    typeMapping.put("dateTime", "Time");
    typeMapping.put("password", "string");
    typeMapping.put("array", "array");
    typeMapping.put("map", "map");
    typeMapping.put("map", "map");

  }

  @Override
  public String escapeReservedWord(String name) {
    return "_" + name;
  }

  @Override
  public String apiFileFolder() {
    return outputFolder;
  }

  public String modelFileFolder() {
    return outputFolder;
  }

  @Override
  public String toVarName(String name) {
    // replace - with _ e.g. created-at => created_at
    name = name.replaceAll("-", "_");

    // if it's all uppper case, do nothing
    if (name.matches("^[A-Z_]*$"))
      return name;

    // camelize (lower first character) the variable name
    // pet_id => petId
    name = camelize(name, true);

    // for reserved word or word starting with number, append _
    if(reservedWords.contains(name) || name.matches("^\\d.*"))
      name = escapeReservedWord(name);

    return name;
  }

  @Override
  public String toParamName(String name) {
    // should be the same as variable name
    return toVarName(name);
  }

  @Override
  public String toModelName(String name) {
    // model name cannot use reserved keyword, e.g. return
    if(reservedWords.contains(name))
      throw new RuntimeException(name + " (reserved word) cannot be used as a model name");

    // camelize the model name
    // phone_number => PhoneNumber
    return camelize(name);
  }

  @Override
  public String toModelFilename(String name) {
    // should be the same as the model name
    return toModelName(name);
  }


  @Override
  public String getTypeDeclaration(Property p) {
    if(p instanceof ArrayProperty) {
      ArrayProperty ap = (ArrayProperty) p;
      Property inner = ap.getItems();
      return "[]" + getTypeDeclaration(inner);
    }
    else if (p instanceof MapProperty) {
      MapProperty mp = (MapProperty) p;
      Property inner = mp.getAdditionalProperties();

      return getSwaggerType(p) + "[String]" + getTypeDeclaration(inner);
    }
    return super.getTypeDeclaration(p);
  }

  @Override
  public String getSwaggerType(Property p) {
    String swaggerType = super.getSwaggerType(p);
    String type = null;
    if(typeMapping.containsKey(swaggerType)) {
      type = typeMapping.get(swaggerType);
      if(languageSpecificPrimitives.contains(type))
        return (type);
    }
    else
      type = swaggerType;
    return toModelName(type);
  }

  @Override
  public String toOperationId(String operationId) {
    // method name cannot use reserved keyword, e.g. return
    if(reservedWords.contains(operationId))
      throw new RuntimeException(operationId + " (reserved word) cannot be used as method name");

    return camelize(operationId, true);
  }


}
