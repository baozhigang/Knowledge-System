# Map
### 1.判断map中是否存在某个key
    if value, ok := mymap["key1"]; ok {
        fmt.Printf(value)
    }
    如果不需要输出则可以如下形式：
    if _, ok := mymap["key1"]; ok {

    }
