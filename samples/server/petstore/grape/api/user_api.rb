require 'json'

module 
  class UserApi
  
    resource :User
    # summary: Create user
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 0,  'Content-type' => 'text/error').finish
        
      end
      params do
        optional :body, type: , desc: 'Created user object'
        
      end 
      POST '/user'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
    resource :User
    # summary: Creates list of users with given input array
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 0,  'Content-type' => 'text/error').finish
        
      end
      params do
        optional :body, type: , desc: 'List of user object'
        
      end 
      POST '/user/createWithArray'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
    resource :User
    # summary: Creates list of users with given input array
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 0,  'Content-type' => 'text/error').finish
        
      end
      params do
        optional :body, type: , desc: 'List of user object'
        
      end 
      POST '/user/createWithList'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
    resource :User
    # summary: Logs user into the system
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 200,  'Content-type' => 'text/error').finish
        Rack::Response.new([''], 400,  'Content-type' => 'text/error').finish
        
      end
      params do
        optional :username, type: , desc: 'The user name for login'
        optional :password, type: , desc: 'The password for login in clear text'
        
      end 
      GET '/user/login'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
    resource :User
    # summary: Logs out current logged in user session
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 0,  'Content-type' => 'text/error').finish
        
      end
      params do
        
      end 
      GET '/user/logout'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
    resource :User
    # summary: Get user by user name
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 404,  'Content-type' => 'text/error').finish
        Rack::Response.new([''], 200,  'Content-type' => 'text/error').finish
        Rack::Response.new([''], 400,  'Content-type' => 'text/error').finish
        
      end
      params do
        requires :username, type: , desc: 'The name that needs to be fetched. Use user1 for testing. '
        
      end 
      GET '/user/{username}'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
    resource :User
    # summary: Updated user
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 404,  'Content-type' => 'text/error').finish
        Rack::Response.new([''], 400,  'Content-type' => 'text/error').finish
        
      end
      params do
        requires :username, type: , desc: 'name that need to be deleted'
        optional :body, type: , desc: 'Updated user object'
        
      end 
      PUT '/user/{username}'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
    resource :User
    # summary: Delete user
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 404,  'Content-type' => 'text/error').finish
        Rack::Response.new([''], 400,  'Content-type' => 'text/error').finish
        
      end
      params do
        requires :username, type: , desc: 'The name that needs to be deleted'
        
      end 
      DELETE '/user/{username}'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
  end
end
