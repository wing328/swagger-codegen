require 'json'


MyApp.add_route('POST', '/user'.gsub /{(.*?)}/, ':\1', {
  "resourcePath" => "/User",
  "summary" => "Create user",
  "nickname" => "create_user", 
  "responseClass" => "void", 
  "endpoint" => "/user".gsub/{(.*?)}/, ':\1', 
  "notes" => "This can only be done by the logged in user.",
  "parameters" => [
    
    
    
    {
      "name" => "body",
      "description" => "Created user object",
      "dataType" => "",
      "paramType" => "body",
    }
    
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end


MyApp.add_route('POST', '/user/createWithArray'.gsub /{(.*?)}/, ':\1', {
  "resourcePath" => "/User",
  "summary" => "Creates list of users with given input array",
  "nickname" => "create_users_with_array_input", 
  "responseClass" => "void", 
  "endpoint" => "/user/createWithArray".gsub/{(.*?)}/, ':\1', 
  "notes" => "",
  "parameters" => [
    
    
    
    {
      "name" => "body",
      "description" => "List of user object",
      "dataType" => "",
      "paramType" => "body",
    }
    
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end


MyApp.add_route('POST', '/user/createWithList'.gsub /{(.*?)}/, ':\1', {
  "resourcePath" => "/User",
  "summary" => "Creates list of users with given input array",
  "nickname" => "create_users_with_list_input", 
  "responseClass" => "void", 
  "endpoint" => "/user/createWithList".gsub/{(.*?)}/, ':\1', 
  "notes" => "",
  "parameters" => [
    
    
    
    {
      "name" => "body",
      "description" => "List of user object",
      "dataType" => "",
      "paramType" => "body",
    }
    
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end


MyApp.add_route('GET', '/user/login'.gsub /{(.*?)}/, ':\1', {
  "resourcePath" => "/User",
  "summary" => "Logs user into the system",
  "nickname" => "login_user", 
  "responseClass" => "string", 
  "endpoint" => "/user/login".gsub/{(.*?)}/, ':\1', 
  "notes" => "",
  "parameters" => [
    {
      "name" => "username",
      "description" => "The user name for login",
      "dataType" => "",
      "paramType" => "query",
      "allowMultiple" => ,
      "allowableValues" => "",
      
    },
    {
      "name" => "password",
      "description" => "The password for login in clear text",
      "dataType" => "",
      "paramType" => "query",
      "allowMultiple" => ,
      "allowableValues" => "",
      
    },
    
    
    
    
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end


MyApp.add_route('GET', '/user/logout'.gsub /{(.*?)}/, ':\1', {
  "resourcePath" => "/User",
  "summary" => "Logs out current logged in user session",
  "nickname" => "logout_user", 
  "responseClass" => "void", 
  "endpoint" => "/user/logout".gsub/{(.*?)}/, ':\1', 
  "notes" => "",
  "parameters" => [
    
    
    
    
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end


MyApp.add_route('GET', '/user/{username}'.gsub /{(.*?)}/, ':\1', {
  "resourcePath" => "/User",
  "summary" => "Get user by user name",
  "nickname" => "get_user_by_name", 
  "responseClass" => "User", 
  "endpoint" => "/user/{username}".gsub/{(.*?)}/, ':\1', 
  "notes" => "",
  "parameters" => [
    
    {
      "name" => "username",
      "description" => "The name that needs to be fetched. Use user1 for testing. ",
      "dataType" => "",
      "paramType" => "path",
    },
    
    
    
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end


MyApp.add_route('PUT', '/user/{username}'.gsub /{(.*?)}/, ':\1', {
  "resourcePath" => "/User",
  "summary" => "Updated user",
  "nickname" => "update_user", 
  "responseClass" => "void", 
  "endpoint" => "/user/{username}".gsub/{(.*?)}/, ':\1', 
  "notes" => "This can only be done by the logged in user.",
  "parameters" => [
    
    {
      "name" => "username",
      "description" => "name that need to be deleted",
      "dataType" => "",
      "paramType" => "path",
    },
    
    
    {
      "name" => "body",
      "description" => "Updated user object",
      "dataType" => "",
      "paramType" => "body",
    }
    
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end


MyApp.add_route('DELETE', '/user/{username}'.gsub /{(.*?)}/, ':\1', {
  "resourcePath" => "/User",
  "summary" => "Delete user",
  "nickname" => "delete_user", 
  "responseClass" => "void", 
  "endpoint" => "/user/{username}".gsub/{(.*?)}/, ':\1', 
  "notes" => "This can only be done by the logged in user.",
  "parameters" => [
    
    {
      "name" => "username",
      "description" => "The name that needs to be deleted",
      "dataType" => "",
      "paramType" => "path",
    },
    
    
    
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end

