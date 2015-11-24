# IF4031-tweetMongo
Tweet sederhana menggunakan database mongodb

=====================================================
##*   IF4130 - PENGEMBANGAN APLIKASI TERDISTRIBUSI   *
###*             	13513601                     *
###*        Akhmad Fakhoni Listiyan Dede             *
=====================================================

Untuk menjalankan program, pastikan server mongo 167.205.35.19 menyala.

Daftar command (lebih lengkapnya bisa dilihat saat menjalankan program) 
To register,    ketik: reg [username] [password] 
To login,       ketik: login [username] [password] 
To exit,        ketik: exit 
To follow,          ketik: follow [username] 
To send tweet,      ketik: tweet [body] 
To see userline,    ketik: userline 
To see timeline,    ketik: timeline 
To logout,          ketik: logout 

Project dalam IDE netbeans 

Untuk menjalankan, langsung saja ke bin dan jalankan .jar nya. 

##### Demo menjalankan program bisa dilihat di 
http://sister.akhfa.me/9-mongo/

##### Git ada di alamat berikut 
https://github.com/akhfa/IF4031-tweetMongo.git

##### Cara menjalankan program:
	Masuk ke folder bin
	java -jar tweetMongo.jar

##### Query untuk melakukan 5 hal di atas
##### Register
	db.users.insert(
	{
	"username" : "akhfa2",
	"password" : "akhfa2"
	}
	)

##### Login
	db.users.find({"username" : "akhfa2"})

##### Friend
	db.friends.insert(
	{
	"username" : "akhfa2",
	"friend"   : "akhfa3",
	"timestamp" : ISODate("2015-11-24T00:00:00Z")
	}
	)

##### Followers
	db.followers.insert(
	{
	"username" : "akhfa2",
	"follower"   : "akhfa3",
	"timestamp" : ISODate("2015-11-24T00:00:00Z")
	}
	)

##### Tweet
	db.tweets.insert(
	{
	"username" : "akhfa",
	"body" : "halooo"
	}
	)

##### Userline
	db.userline.insert(
	{
	"username" : "akhfa",
	"time" : ISODate("2015-11-20T05:44:34.160Z"),
	"tweet_id" : "5653f9422b5ea272cf972653"
	}
	)

##### Timeline
	db.timeline.insert(
	{
	"username" : "akhfa",
	"time" : ISODate("2015-11-20T05:44:34.160Z"),
	"tweet_id" : "5653f9422b5ea272cf972653"
	}
	)

##### Untuk memasukkan ke tiap username, maka perlu get follower terlebih dahulu berdasarkan username tertentu
	db.followers.find({"username" : "akhfa2"})

##### Menampilkan tweet berdasarkan user tertentu
	db.tweets.find({"username" : "akhfa2"})


##### Menampilkan userline untuk setiap user, cari dulu di tabel userline
	db.userline.find({"username" : "user2"})

	Kemudian akan didapatkan hasil seperti berikut: { "_id" : ObjectId("5653f9422b5ea272cf972654"), "username" : "user2", "time" : ISODate("2015-11-24T05:44:34.160Z"), "tweet_id" : "5653f9422b5ea272cf972653" }

##### Ambil tweet_id nya, dan cari di collection tweets
	db.tweets.find(
	{
	"_id" : ObjectId("5653f9422b5ea272cf972653")
	}
	)

##### Dan akan muncul tweetnya
	{ "_id" : ObjectId("5653f9422b5ea272cf972653"), "username" : "user2", "body" : "halo user 3 setelah memfollow user 4" }


##### Untuk menampilkan timeline, cari dulu di tabel timeline
	db.userline.find({"username" : "user2"})

	Akan muncul seperti berikut: { "_id" : ObjectId("5653f8ff2b5ea272cf972650"), "username" : "user2", "time" : ISODate("2015-11-24T05:43:27.254Z"), "tweet_id" : "5653f8ff2b5ea272cf97264e" }

##### Baru cari dari collections tweets berdasarkan tweet_id
	db.tweets.find( { "_id" : ObjectId("5653f8ff2b5ea272cf97264e") } )
