Bu application salesart'ın "invoice" tablosundaki kayıtları yeni açılan "customer_financial_transaction" tablosuna migrate etmek ve
"customer" tablosundaki "customer_risk_info_id" colonu null olan kayıtlar için "customer_risk_info" create etmek için yazıldı. 

"application.properties" dosyasında salesart db'sinin connection string'i kullanıcı adı ve şifresiyle tanımlanması ve collection-service'nin url'ni tanımlamamız gerekli.

"application.properties" dosyasına tanımladığımız "search.date" ile verdiğimiz tarihten önceki kayıtlar üzerinde işlem gerçekleştirilir. örnek format (1999-01-01 00:00:00)

Bu işlemi gerçekleştirmek için

..../api/trigger/billing-migration
..../api/trigger/customer-risk-info-create

endpointlerine "GET" isteğinde bulunmamız yeterli.
