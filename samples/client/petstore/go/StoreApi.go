package swagger;

import (
  "encoding/json"
  "fmt"
  "net/url"
)

type StoreApi struct { 
  basePath string
  apiInvoker ApiInvoker
}

func NewStoreApi() *obj{
    return &obj{basePath:"http://petstore.swagger.io/v2", apiInvoker:ApiInvoker.GetInstance()}
}

  
  /**
   * Returns pet inventories by status
   * Returns a map of status codes to quantities
   * @return Map[String]int32
   */
  func (response Map[String]int32) getInventory ()  {
    postBody := nil
    

    // create path and map variables
    path := "/store/inventory".Replace("\\{format\\}","json")
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string {  }

    
    

      response := apiInvoker.CallAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return ApiInvoker.Deserialize(response, "map", "Map")
      } else {
        return 
      }
  }
  
  /**
   * Place an order for a pet
   * 
   * @param body order placed for purchasing the pet
   * @return Order
   */
  func (response Order) placeOrder (body )  {
    postBody := body
    

    // create path and map variables
    path := "/store/order".Replace("\\{format\\}","json")
    

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
        return ApiInvoker.Deserialize(response, "", "Order")
      } else {
        return 
      }
  }
  
  /**
   * Find purchase order by ID
   * For valid response try integer IDs with value &lt;= 5 or &gt; 10. Other values will generated exceptions
   * @param orderId ID of pet that needs to be fetched
   * @return Order
   */
  func (response Order) getOrderById (orderId )  {
    postBody := nil
    
    // verify the required parameter 'orderId' is set
    if orderId == nil {
       return 0, fmt.Error("Missing the required parameter 'orderId' when calling getOrderById")
    }
    

    // create path and map variables
    path := "/store/order/{orderId}".Replace("\\{format\\}","json")
    path = path.Replace("\\{" + "orderId" + "\\}", ApiInvoker.EscapeString(orderId))
    

    queryParams := map[string]string {}
    headerParams := map[string]string {}
    formParams := map[string]string {}

    
    
    contentTypes := []string {  }

    
    

      response := apiInvoker.CallAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType)
      if response {
        return ApiInvoker.Deserialize(response, "", "Order")
      } else {
        return 
      }
  }
  
  /**
   * Delete purchase order by ID
   * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
   * @param orderId ID of the order that needs to be deleted
   * @return void
   */
  func (response ) deleteOrder (orderId )  {
    postBody := nil
    
    // verify the required parameter 'orderId' is set
    if orderId == nil {
       return 0, fmt.Error("Missing the required parameter 'orderId' when calling deleteOrder")
    }
    

    // create path and map variables
    path := "/store/order/{orderId}".Replace("\\{format\\}","json")
    path = path.Replace("\\{" + "orderId" + "\\}", ApiInvoker.EscapeString(orderId))
    

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
  
