# sell-demo-on-wechat
## 基于Spring Boot开发的微信平台点餐系统

### 买家端
采用微信公众平台的网页授权功能获得用户的基本信息（openid），前端项目页面是现成的。在买家端页面中有商品类别和商品的信息，买家可以挑选商品，填写个人信息后进行下单。之后在微信内调用h5支付（使用SDK完成），无论是否支付都会跳转到订单详情页面，可以选择取消订单，取消订单后会发起退款。在买家端使用redis缓存对商品信息列表进行缓存，在商品信息没有修改的情况下用户访问的是redis缓存，提高了访问速度同时降低了服务器的访问压力。同时对于加入秒杀的商品使用redis分布式锁实现了独占访问。

### 卖家端
采用web登陆，使用微信开放平台的扫码登陆功能。在卖家端能够看到所有的订单，可以查看订单详情，完结订单和取消订单。同时还可以对商品信息和类目的信息进行修改，可以修改商品名称，价格，描述，图片，所属类目，还可以实现商品的上下架功能。同时还能完成类目的增加，删除等操作。在卖家端使用redis保存session，结合cookie实现登陆用户信息的保存，结合使用aop实现了对未登录用户的拦截。