require 'json'

module 
  class StoreApi
  
    resource :Store
    # summary: Returns pet inventories by status
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 200,  'Content-type' => 'text/error').finish
        
      end
      params do
        
      end 
      GET '/store/inventory'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
    resource :Store
    # summary: Place an order for a pet
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 200,  'Content-type' => 'text/error').finish
        Rack::Response.new([''], 400,  'Content-type' => 'text/error').finish
        
      end
      params do
        optional :body, type: , desc: 'order placed for purchasing the pet'
        
      end 
      POST '/store/order'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
    resource :Store
    # summary: Find purchase order by ID
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 404,  'Content-type' => 'text/error').finish
        Rack::Response.new([''], 200,  'Content-type' => 'text/error').finish
        Rack::Response.new([''], 400,  'Content-type' => 'text/error').finish
        
      end
      params do
        requires :orderId, type: , desc: 'ID of pet that needs to be fetched'
        
      end 
      GET '/store/order/{orderId}'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
    resource :Store
    # summary: Delete purchase order by ID
    # description: 
      rescue_from :all do |e|
        Rack::Response.new([''], 404,  'Content-type' => 'text/error').finish
        Rack::Response.new([''], 400,  'Content-type' => 'text/error').finish
        
      end
      params do
        requires :orderId, type: , desc: 'ID of the order that needs to be deleted'
        
      end 
      DELETE '/store/order/{orderId}'.gsub /{(.*?)}/, ':\1' do
  
      end
    end
  
  end
end
