# OrderCoffee

* Ứng dụng xây dựng trên môi trường android.
* Ứng dụng bao gồm cả client android app và server nhận và xử lí request.
---
![OrderHomePage](https://i.imgur.com/z0iW4bu.png)
---
## Các thư viện sử dụng và cấu hình:
1. Thư viện
- Thư viện design
```
implementation 'com.android.support:appcompat-v7:28.0.0'  
implementation 'com.android.support:design:28.0.0'
```
- Thư viện đọc mã QR;
 ```
implementation 'com.journeyapps:zxing-android-embedded:3.6.0'
implementation 'com.google.zxing:core:3.3.2'
```
- Thư viện Retrofit2 kết nối Server:
```
implementation 'com.squareup.retrofit2:retrofit:2.6.1'  
implementation 'com.squareup.retrofit2:converter-gson:2.6.1'
```
- Thư viện Picaso tải hình ảnh:
```
implementation 'com.squareup.picasso:picasso:2.71828'
```
2. Cấu hình đặc biệt với android P (androdi 9 trở lên):
- Tạo file theo đường dẫn: res/xml/network_security_config.xml:
```xml
<?xml version="1.0" encoding="utf-8"?>  
<network-security-config>  
	 <domain-config cleartextTrafficPermitted="true">  
	 <domain includeSubdomains="true">192.168.1.102</domain>  
 </domain-config></network-security-config>
```
- Trong AndroidManifest.xml thêm dòng:
```xml
<application  
  android:networkSecurityConfig="@xml/network_security_config"
 ....
 />
```
---
## Thông tin ứng dụng:
```xml
<!-- Kết nối csdl -->
	<bean id="dbOrderCoffee" class="com.ttcscn.database.DatabaseOrderCoffee">
        <property name="dataSource" ref="dataSource"/>
    </bean>
	<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
		<property name="driverClassName" value="com.mysql.jdbc.Driver"/>
		<property name="url" value="jdbc:mysql://localhost:3306/ordercoffee?serverTimezone=Asia/Ho_Chi_Minh"/>
		<property name="username" value="root"/>
		<property name="password" value=""/>
	</bean>
```
