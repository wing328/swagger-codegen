package swagger

import (
  "encoding/json"
)

type Pet struct {
  id  int64  `json:"id"`
  category  Category  `json:"category"`
  name  string  `json:"name"`
  photoUrls  []string  `json:"photoUrls"`
  tags  []Tag  `json:"tags"`
  status  string  `json:"status"`
  
}
