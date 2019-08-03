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

## 消息
### 获取消息列表 
~~~js
POST http://39.108.108.237/yliu/msg

request = {
    "receiverPhone":"00000000000",//接收人手机
    "from":"yyyy-MM-dd HH:MM:SS",//查询开始时间
    "to":"yyyy-MM-dd HH:MM:SS" //查询结束时间
    }    

response = {
  "code": 0,
  "data": [${msg}]
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


