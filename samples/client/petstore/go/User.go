package swagger

import (
  "encoding/json"
)

type User struct {
  id  int64  `json:"id"`
  username  string  `json:"username"`
  firstName  string  `json:"firstName"`
  lastName  string  `json:"lastName"`
  email  string  `json:"email"`
  password  string  `json:"password"`
  phone  string  `json:"phone"`
  userStatus  int32  `json:"userStatus"`
  
}
