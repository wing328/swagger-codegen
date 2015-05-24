package swagger;

import (
  "encoding/json"
  "fmt"
  "net/url"
)

type PetApi struct { 
  basePath string
  apiInvoker ApiInvoker
}

func NewPetApi() *obj{
    return &obj{basePath:"http://petstore.swagger.io/v2", apiInvoker:ApiInvoker.GetInstance()}
}

  
  /**
   * Update an existing pet
   * 
   * @param body Pet object that needs to be added to the store
   * @return void
   */
  func (response ) updatePet (body )  {
    postBody := body
    

    // create path and map variables
    path := "/pet".Replace("\\{format\\}","json")
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string { "application/json","application/xml", }

    
    // body params
    _tempBody := nil
    if body {
      _tempBody = body
    }

      response := apiInvoker.CallAPI(basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return 
      } else {
        return nil
      }
  }
  
  /**
   * Add a new pet to the store
   * 
   * @param body Pet object that needs to be added to the store
   * @return void
   */
  func (response ) addPet (body )  {
    postBody := body
    

    // create path and map variables
    path := "/pet".Replace("\\{format\\}","json")
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string { "application/json","application/xml", }

    
    // body params
    _tempBody := nil
    if body {
      _tempBody = body
    }

      response := apiInvoker.CallAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return 
      } else {
        return nil
      }
  }
  
  /**
   * Finds Pets by status
   * Multiple status values can be provided with comma seperated strings
   * @param status Status values that need to be considered for filter
   * @return []Pet
   */
  func (response []Pet) findPetsByStatus (status )  {
    postBody := nil
    

    // create path and map variables
    path := "/pet/findByStatus".Replace("\\{format\\}","json")
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    if status {
      queryParams["status"] = ApiInvoker.ParameterToString(status);
    }
    
    
    contentTypes := []string {  }

    
    

      response := apiInvoker.CallAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return ApiInvoker.Deserialize(response, "array", "Pet")
      } else {
        return 
      }
  }
  
  /**
   * Finds Pets by tags
   * Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing.
   * @param tags Tags to filter by
   * @return []Pet
   */
  func (response []Pet) findPetsByTags (tags )  {
    postBody := nil
    

    // create path and map variables
    path := "/pet/findByTags".Replace("\\{format\\}","json")
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    if tags {
      queryParams["tags"] = ApiInvoker.ParameterToString(tags);
    }
    
    
    contentTypes := []string {  }

    
    

      response := apiInvoker.CallAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return ApiInvoker.Deserialize(response, "array", "Pet")
      } else {
        return 
      }
  }
  
  /**
   * Find pet by ID
   * Returns a pet when ID &lt; 10.  ID &gt; 10 or nonintegers will simulate API error conditions
   * @param petId ID of pet that needs to be fetched
   * @return Pet
   */
  func (response Pet) getPetById (petId )  {
    postBody := nil
    
    // verify the required parameter 'petId' is set
    if petId == nil {
       return 0, fmt.Error("Missing the required parameter 'petId' when calling getPetById")
    }
    

    // create path and map variables
    path := "/pet/{petId}".Replace("\\{format\\}","json")
    path = path.Replace("\\{" + "petId" + "\\}", ApiInvoker.EscapeString(petId))
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string {  }

    
    

      response := apiInvoker.CallAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return ApiInvoker.Deserialize(response, "", "Pet")
      } else {
        return 
      }
  }
  
  /**
   * Updates a pet in the store with form data
   * 
   * @param petId ID of pet that needs to be updated
   * @param name Updated name of the pet
   * @param status Updated status of the pet
   * @return void
   */
  func (response ) updatePetWithForm (petId , name , status )  {
    postBody := nil
    
    // verify the required parameter 'petId' is set
    if petId == nil {
       return 0, fmt.Error("Missing the required parameter 'petId' when calling updatePetWithForm")
    }
    

    // create path and map variables
    path := "/pet/{petId}".Replace("\\{format\\}","json")
    path = path.Replace("\\{" + "petId" + "\\}", ApiInvoker.EscapeString(petId))
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string { "application/x-www-form-urlencoded", }

    // form params
    if name {
      formParams["name"] = ApiInvoker.ToFormValue(name)
    }// form params
    if status {
      formParams["status"] = ApiInvoker.ToFormValue(status)
    }
    

      response := apiInvoker.CallAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return 
      } else {
        return nil
      }
  }
  
  /**
   * Deletes a pet
   * 
   * @param apiKey 
   * @param petId Pet id to delete
   * @return void
   */
  func (response ) deletePet (apiKey , petId )  {
    postBody := nil
    
    // verify the required parameter 'petId' is set
    if petId == nil {
       return 0, fmt.Error("Missing the required parameter 'petId' when calling deletePet")
    }
    

    // create path and map variables
    path := "/pet/{petId}".Replace("\\{format\\}","json")
    path = path.Replace("\\{" + "petId" + "\\}", ApiInvoker.EscapeString(petId))
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    headerParams["api_key"] = ApiInvoker.ParameterToString(apiKey);
    
    contentTypes := []string {  }

    
    

      response := apiInvoker.CallAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return 
      } else {
        return nil
      }
  }
  
  /**
   * uploads an image
   * 
   * @param petId ID of pet to update
   * @param additionalMetadata Additional data to pass to server
   * @param file file to upload
   * @return void
   */
  func (response ) uploadFile (petId , additionalMetadata , file )  {
    postBody := nil
    
    // verify the required parameter 'petId' is set
    if petId == nil {
       return 0, fmt.Error("Missing the required parameter 'petId' when calling uploadFile")
    }
    

    // create path and map variables
    path := "/pet/{petId}/uploadImage".Replace("\\{format\\}","json")
    path = path.Replace("\\{" + "petId" + "\\}", ApiInvoker.EscapeString(petId))
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string { "multipart/form-data", }

    // form params
    if additionalMetadata {
      formParams["additionalMetadata"] = ApiInvoker.ToFormValue(additionalMetadata)
    }// form params
    if file {
      formParams["file"] = "@" . ApiInvoker.ToFormValue(file)
    }
    

      response := apiInvoker.CallAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return 
      } else {
        return nil
      }
  }
  
