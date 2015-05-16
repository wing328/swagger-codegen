package swagger

import (
  "encoding/json"
)

type Order struct {
  id  int64  `json:"id"`
  petId  int64  `json:"petId"`
  quantity  int32  `json:"quantity"`
  shipDate  DateTime  `json:"shipDate"`
  status  string  `json:"status"`
  complete  bool  `json:"complete"`
  
}
