# Currency converter

Its a currency converter web site which will have input fields for amount, from/to
currency selection you want to exchange.

There are couples of things that are taken care of: 
1. Currency provided for conversion should not be less than 0.
2. Invalid currency will throw bad request.
3. Enabled default caching for exchange-rates API calls.


How to run this app: 
1. clone it to local machine.
2. Run the app as springBoot app.
3. Once the app is started. 
 http://localhost:8081/api/v1/currencies -- will retrieve all currencies available.(GET)
 http://localhost:8081/api/v1/currency-converter -- will convert currency from and to.(POST)

Future Scope:
1. Instead of using default caching, we can use Redis, Ecache if needed to scale to full fledge cache.(minimum changes).
2. Make User Interface more user friendly.
3. Include negative edge case validations.
