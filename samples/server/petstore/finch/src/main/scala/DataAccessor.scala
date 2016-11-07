package io.swagger.petstore

trait DataAccessor {
    // TODO: apiInfo -> apis -> operations = ???
    // NOTE: ??? throws a not implemented exception

        /**
        * 
        * @return A Unit
        */
        def Pet_addPet(body: Pet): Unit = ???

        /**
        * 
        * @return A Unit
        */
        def Pet_deletePet(petId: Long, apiKey: String): Unit = ???

        /**
        * 
        * @return A List[Pet]
        */
        def Pet_findPetsByStatus(status: List[String]): List[Pet] = ???

        /**
        * 
        * @return A List[Pet]
        */
        def Pet_findPetsByTags(tags: List[String]): List[Pet] = ???

        /**
        * 
        * @return A Pet
        */
        def Pet_getPetById(petId: Long): Pet = ???

        /**
        * 
        * @return A Unit
        */
        def Pet_updatePet(body: Pet): Unit = ???

        /**
        * 
        * @return A Unit
        */
        def Pet_updatePetWithForm(petId: Long, name: String, status: String): Unit = ???

        /**
        * 
        * @return A ApiResponse
        */
        def Pet_uploadFile(petId: Long, additionalMetadata: String, file: File): ApiResponse = ???

        /**
        * 
        * @return A Unit
        */
        def Store_deleteOrder(orderId: String): Unit = ???

        /**
        * 
        * @return A Map[String, Int]
        */
        def Store_getInventory(): Map[String, Int] = ???

        /**
        * 
        * @return A Order
        */
        def Store_getOrderById(orderId: Long): Order = ???

        /**
        * 
        * @return A Order
        */
        def Store_placeOrder(body: Order): Order = ???

        /**
        * 
        * @return A Unit
        */
        def User_createUser(body: User): Unit = ???

        /**
        * 
        * @return A Unit
        */
        def User_createUsersWithArrayInput(body: List[User]): Unit = ???

        /**
        * 
        * @return A Unit
        */
        def User_createUsersWithListInput(body: List[User]): Unit = ???

        /**
        * 
        * @return A Unit
        */
        def User_deleteUser(username: String): Unit = ???

        /**
        * 
        * @return A User
        */
        def User_getUserByName(username: String): User = ???

        /**
        * 
        * @return A String
        */
        def User_loginUser(username: String, password: String): String = ???

        /**
        * 
        * @return A Unit
        */
        def User_logoutUser(): Unit = ???

        /**
        * 
        * @return A Unit
        */
        def User_updateUser(username: String, body: User): Unit = ???

}