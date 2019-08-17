# yliu_appserver
## Model

### 消息Model
~~~js
${msg} = {
    "content": "xx",//信息内容
    "msgDate": "yyyy-MM-dd HH:MM:SS",//消息日期
    "receiverPhone": "00000000000",//接收人
    "senderName": "xx",//发送人
    "senderPhone": "00000000000"/发送人手机
  }
~~~

### 分页Model
~~~js
${Page} = {
	    "content": [{}],//数据内容
	    "empty": false,//是否为空
	    "first": true,//是否为第一页
	    "last": true,//是否为最后一页
	    "number": 0,//
	    "numberOfElements": 1,
	    "pageable": {
	      "offset": 0,
	      "pageNumber": 0,
	      "pageSize": 12,
	      "paged": true,
	      "sort": {
	        "empty": true,
	        "sorted": false,
	        "unsorted": true
	      },
	      "unpaged": false
	    },
	    "size": 12,//分页大小
	    "sort": {
	      "$ref": "$.data.pageable.sort"
	    },
	    "totalElements": 1,//总记录数
	    "totalPages": 1 //总页数
}

## 消息
### 获取消息列表 
~~~js
POST http://39.108.108.237/yliu/msg?page={page}&size={size}

request = {
    "receiverPhone":"00000000000",//接收人手机
    "from":"yyyy-MM-dd HH:MM:SS",//查询开始时间
    "to":"yyyy-MM-dd HH:MM:SS" //查询结束时间
    }    

response = {
  "code": 0,
  "data": [${Page}]
}
~~~

### 推送消息 
~~~js
POST http://39.108.108.237/yliu/msg/push

request = ${msg}

response = {
  "code": 0,
  "message": "成功"
}
~~~


