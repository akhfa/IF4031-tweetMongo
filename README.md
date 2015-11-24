# IF4031-tweetMongo
Tweet sederhana menggunakan database mongodb

=====================================================<br>
##*   IF4130 - PENGEMBANGAN APLIKASI TERDISTRIBUSI   *<br>
###*             	13513601                     *<br>
###*        Akhmad Fakhoni Listiyan Dede             *<br>
=====================================================<br>

Untuk menjalankan program, pastikan server mongo 167.205.35.19 menyala.

Daftar command (lebih lengkapnya bisa dilihat saat menjalankan program) <br>
To register,    ketik: reg [username] [password] <br>
To login,       ketik: login [username] [password] <br>
To exit,        ketik: exit <br>
To follow,          ketik: follow [username] <br>
To send tweet,      ketik: tweet [body] <br>
To see userline,    ketik: userline <br>
To see timeline,    ketik: timeline <br>
To logout,          ketik: logout <br>

Project dalam IDE netbeans <br>

Untuk menjalankan, langsung saja ke bin dan jalankan .jar nya. <br>

##### Demo menjalankan program bisa dilihat di <br>
http://sister.akhfa.me/9-mongo/

##### Git ada di alamat berikut <br>
https://github.com/akhfa/IF4031-tweetMongo.git<br>

##### Cara menjalankan program:<br>
	Masuk ke folder bin<br>
	java -jar tweetMongo.jar<br>
<br>
##### Query untuk melakukan 5 hal di atas:<br>
	<br>
	##### Register<br>
	db.users.insert(<br>
... {<br>
... "username" : "akhfa2",<br>
... "password" : "akhfa2"<br>
... }<br>
... )<br>

	##### Login<br>
	db.users.find({"username" : "akhfa2"})<br>
<br>
	##### Friend<br>
	db.friends.insert(<br>
... {<br>
... "username" : "akhfa2",<br>
... "friend"   : "akhfa3",<br>
... "timestamp" : ISODate("2015-11-24T00:00:00Z")<br>
... }<br>
... )<br>
<br>
	##### Followers<br>
	db.followers.insert(<br>
... {<br>
... "username" : "akhfa2",<br>
... "follower"   : "akhfa3",<br>
... "timestamp" : ISODate("2015-11-24T00:00:00Z")<br>
... }<br>
... )<br>
<br>
	##### Tweet<br>
	db.tweets.insert(<br>
... {<br>
... "username" : "akhfa",<br>
... "body" : "halooo"<br>
... }<br>
... )<br>
<br>
	##### Userline<br>
	db.userline.insert(<br>
... {<br>
... "username" : "akhfa",<br>
... "time" : ISODate("2015-11-20T05:44:34.160Z"),<br>
... "tweet_id" : "5653f9422b5ea272cf972653"<br>
... }<br>
... )<br>

	##### Timeline<br>
	db.timeline.insert(<br>
... {<br>
... "username" : "akhfa",<br>
... "time" : ISODate("2015-11-20T05:44:34.160Z"),<br>
... "tweet_id" : "5653f9422b5ea272cf972653"<br>
... }<br>
... )<br>
<br>
	##### Untuk memasukkan ke tiap username, maka perlu get follower terlebih dahulu berdasarkan username tertentu<br>
	db.followers.find({"username" : "akhfa2"})<br>
<br>
	##### Menampilkan tweet berdasarkan user tertentu<br>
	db.tweets.find({"username" : "akhfa2"})<br>
<br>
<br>
	##### Menampilkan userline untuk setiap user, cari dulu di tabel userline<br>
	db.userline.find({"username" : "user2"})<br>
<br>
	Kemudian akan didapatkan hasil seperti berikut: { "_id" : ObjectId("5653f9422b5ea272cf972654"), "username" : "user2", "time" : ISODate("2015-11-24T05:44:34.160Z"), "tweet_id" : "5653f9422b5ea272cf972653" }<br>
<br>
	##### Ambil tweet_id nya, dan cari di collection tweets<br>
	db.tweets.find(<br>
... {<br>
... "_id" : ObjectId("5653f9422b5ea272cf972653")<br>
... }<br>
... )<br>
<br>
	##### Dan akan muncul tweetnya<br>
	{ "_id" : ObjectId("5653f9422b5ea272cf972653"), "username" : "user2", "body" : "halo user 3 setelah memfollow user 4" }<br>
<br>
<br>
	##### Untuk menampilkan timeline, cari dulu di tabel timeline<br>
	db.userline.find({"username" : "user2"})<br>
<br>
	Akan muncul seperti berikut: { "_id" : ObjectId("5653f8ff2b5ea272cf972650"), "username" : "user2", "time" : ISODate("2015-11-24T05:43:27.254Z"), "tweet_id" : "5653f8ff2b5ea272cf97264e" }<br>
<br>
	##### Baru cari dari collections tweets berdasarkan tweet_id<br>
	db.tweets.find( { "_id" : ObjectId("5653f8ff2b5ea272cf97264e") } )<br>



