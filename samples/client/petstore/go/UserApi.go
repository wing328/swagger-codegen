package swagger;

import (
  "encoding/json"
  "fmt"
  "net/url"
)

type UserApi struct { 
  basePath string
  apiInvoker ApiInvoker
}

func NewUserApi() *obj{
    return &obj{basePath:"http://petstore.swagger.io/v2", apiInvoker:ApiInvoker.GetInstance()}
}

  
  /**
   * Create user
   * This can only be done by the logged in user.
   * @param body Created user object
   * @return void
   */
  func (response ) createUser (body )  {
    postBody := body
    

    // create path and map variables
    path := "/user".Replace("\\{format\\}","json")
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string {  }

    
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
   * Creates list of users with given input array
   * 
   * @param body List of user object
   * @return void
   */
  func (response ) createUsersWithArrayInput (body )  {
    postBody := body
    

    // create path and map variables
    path := "/user/createWithArray".Replace("\\{format\\}","json")
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string {  }

    
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
   * Creates list of users with given input array
   * 
   * @param body List of user object
   * @return void
   */
  func (response ) createUsersWithListInput (body )  {
    postBody := body
    

    // create path and map variables
    path := "/user/createWithList".Replace("\\{format\\}","json")
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string {  }

    
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
   * Logs user into the system
   * 
   * @param username The user name for login
   * @param password The password for login in clear text
   * @return string
   */
  func (response string) loginUser (username , password )  {
    postBody := nil
    

    // create path and map variables
    path := "/user/login".Replace("\\{format\\}","json")
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    if username {
      queryParams["username"] = ApiInvoker.ParameterToString(username);
    }
    if password {
      queryParams["password"] = ApiInvoker.ParameterToString(password);
    }
    
    
    contentTypes := []string {  }

    
    

      response := apiInvoker.CallAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return ApiInvoker.Deserialize(response, "", "string")
      } else {
        return 
      }
  }
  
  /**
   * Logs out current logged in user session
   * 
   * @return void
   */
  func (response ) logoutUser ()  {
    postBody := nil
    

    // create path and map variables
    path := "/user/logout".Replace("\\{format\\}","json")
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string {  }

    
    

      response := apiInvoker.CallAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return 
      } else {
        return nil
      }
  }
  
  /**
   * Get user by user name
   * 
   * @param username The name that needs to be fetched. Use user1 for testing. 
   * @return User
   */
  func (response User) getUserByName (username )  {
    postBody := nil
    
    // verify the required parameter 'username' is set
    if username == nil {
       return 0, fmt.Error("Missing the required parameter 'username' when calling getUserByName")
    }
    

    // create path and map variables
    path := "/user/{username}".Replace("\\{format\\}","json")
    path = path.Replace("\\{" + "username" + "\\}", ApiInvoker.EscapeString(username))
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string {  }

    
    

      response := apiInvoker.CallAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return ApiInvoker.Deserialize(response, "", "User")
      } else {
        return 
      }
  }
  
  /**
   * Updated user
   * This can only be done by the logged in user.
   * @param username name that need to be deleted
   * @param body Updated user object
   * @return void
   */
  func (response ) updateUser (username , body )  {
    postBody := body
    
    // verify the required parameter 'username' is set
    if username == nil {
       return 0, fmt.Error("Missing the required parameter 'username' when calling updateUser")
    }
    

    // create path and map variables
    path := "/user/{username}".Replace("\\{format\\}","json")
    path = path.Replace("\\{" + "username" + "\\}", ApiInvoker.EscapeString(username))
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string {  }

    
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
   * Delete user
   * This can only be done by the logged in user.
   * @param username The name that needs to be deleted
   * @return void
   */
  func (response ) deleteUser (username )  {
    postBody := nil
    
    // verify the required parameter 'username' is set
    if username == nil {
       return 0, fmt.Error("Missing the required parameter 'username' when calling deleteUser")
    }
    

    // create path and map variables
    path := "/user/{username}".Replace("\\{format\\}","json")
    path = path.Replace("\\{" + "username" + "\\}", ApiInvoker.EscapeString(username))
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string {  }

    
    

      response := apiInvoker.CallAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return 
      } else {
        return nil
      }
  }
  
