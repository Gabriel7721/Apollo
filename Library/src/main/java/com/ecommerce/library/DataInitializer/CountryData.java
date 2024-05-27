package com.ecommerce.library.DataInitializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryData implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();

            // Array of country names
            String[] countries = {
                    "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria",
                    "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan",
                    "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia",
                    "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo, Democratic Republic of the", "Congo, Republic of the",
                    "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador",
                    "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland", "France",
                    "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau",
                    "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland",
                    "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South",
                    "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania",
                    "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius",
                    "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia",
                    "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Norway", "Oman",
                    "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar",
                    "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia",
                    "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
                    "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan",
                    "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu",
                    "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela",
                    "Vietnam", "Yemen", "Zambia", "Zimbabwe"
            };

            // Map of country to its cities
            Map<String, String[]> countryToCities = new HashMap<>();
            countryToCities.put("Afghanistan", new String[]{"Kabul", "Kandahar", "Herat"});
            countryToCities.put("Albania", new String[]{"Tirana", "Durres", "Vlorë"});
            countryToCities.put("Algeria", new String[]{"Algiers", "Oran", "Constantine"});
            countryToCities.put("Andorra", new String[]{"Andorra la Vella", "Escaldes-Engordany", "Encamp"});
            countryToCities.put("Angola", new String[]{"Luanda", "N'dalatando", "Huambo"});
            countryToCities.put("Antigua and Barbuda", new String[]{"Saint John's", "All Saints", "Liberta"});
            countryToCities.put("Argentina", new String[]{"Buenos Aires", "Córdoba", "Rosario"});
            countryToCities.put("Armenia", new String[]{"Yerevan", "Gyumri", "Vanadzor"});
            countryToCities.put("Australia", new String[]{"Sydney", "Melbourne", "Brisbane"});
            countryToCities.put("Austria", new String[]{"Vienna", "Graz", "Linz"});
            countryToCities.put("Azerbaijan", new String[]{"Baku", "Ganja", "Sumqayit"});
            countryToCities.put("Bahamas", new String[]{"Nassau", "Freeport", "West End"});
            countryToCities.put("Bahrain", new String[]{"Manama", "Riffa", "Muharraq"});
            countryToCities.put("Bangladesh", new String[]{"Dhaka", "Chittagong", "Khulna"});
            countryToCities.put("Barbados", new String[]{"Bridgetown", "Speightstown", "Oistins"});
            countryToCities.put("Belarus", new String[]{"Minsk", "Gomel", "Mogilev"});
            countryToCities.put("Belgium", new String[]{"Brussels", "Antwerp", "Ghent"});
            countryToCities.put("Belize", new String[]{"Belize City", "San Ignacio", "Orange Walk"});
            countryToCities.put("Benin", new String[]{"Porto-Novo", "Cotonou", "Parakou"});
            countryToCities.put("Bhutan", new String[]{"Thimphu", "Phuntsholing", "Punakha"});
            countryToCities.put("Bolivia", new String[]{"La Paz", "Santa Cruz de la Sierra", "Cochabamba"});
            countryToCities.put("Bosnia and Herzegovina", new String[]{"Sarajevo", "Banja Luka", "Mostar"});
            countryToCities.put("Botswana", new String[]{"Gaborone", "Francistown", "Molepolole"});
            countryToCities.put("Brazil", new String[]{"São Paulo", "Rio de Janeiro", "Brasília"});
            countryToCities.put("Brunei", new String[]{"Bandar Seri Begawan", "Kuala Belait", "Seria"});
            countryToCities.put("Bulgaria", new String[]{"Sofia", "Plovdiv", "Varna"});
            countryToCities.put("Burkina Faso", new String[]{"Ouagadougou", "Bobo-Dioulasso", "Koudougou"});
            countryToCities.put("Burundi", new String[]{"Gitega", "Bujumbura", "Ngozi"});
            countryToCities.put("Cabo Verde", new String[]{"Praia", "Mindelo", "Santa Maria"});
            countryToCities.put("Cambodia", new String[]{"Phnom Penh", "Siem Reap", "Battambang"});
            countryToCities.put("Cameroon", new String[]{"Yaoundé", "Douala", "Garoua"});
            countryToCities.put("Canada", new String[]{"Toronto", "Vancouver", "Montreal"});
            countryToCities.put("Central African Republic", new String[]{"Bangui", "Bimbo", "Berbérati"});
            countryToCities.put("Chad", new String[]{"N'Djamena", "Moundou", "Sarh"});
            countryToCities.put("Chile", new String[]{"Santiago", "Valparaíso", "Concepción"});
            countryToCities.put("China", new String[]{"Beijing", "Shanghai", "Shenzhen"});
            countryToCities.put("Colombia", new String[]{"Bogotá", "Medellín", "Cali"});
            countryToCities.put("Comoros", new String[]{"Moroni", "Mutsamudu", "Fomboni"});
            countryToCities.put("Congo, Democratic Republic of the", new String[]{"Kinshasa", "Lubumbashi", "Mbuji-Mayi"});
            countryToCities.put("Congo, Republic of the", new String[]{"Brazzaville", "Pointe-Noire", "Dolisie"});
            countryToCities.put("Costa Rica", new String[]{"San José", "Alajuela", "Heredia"});
            countryToCities.put("Croatia", new String[]{"Zagreb", "Split", "Rijeka"});
            countryToCities.put("Cuba", new String[]{"Havana", "Santiago de Cuba", "Camagüey"});
            countryToCities.put("Cyprus", new String[]{"Nicosia", "Limassol", "Larnaca"});
            countryToCities.put("Czech Republic", new String[]{"Prague", "Brno", "Ostrava"});
            countryToCities.put("Denmark", new String[]{"Copenhagen", "Aarhus", "Odense"});
            countryToCities.put("Djibouti", new String[]{"Djibouti", "Ali Sabieh", "Tadjourah"});
            countryToCities.put("Dominica", new String[]{"Roseau", "Portsmouth", "Marigot"});
            countryToCities.put("Dominican Republic", new String[]{"Santo Domingo", "Santiago de los Caballeros", "La Romana"});
            countryToCities.put("Ecuador", new String[]{"Quito", "Guayaquil", "Cuenca"});
            countryToCities.put("Egypt", new String[]{"Cairo", "Alexandria", "Giza"});
            countryToCities.put("El Salvador", new String[]{"San Salvador", "Santa Ana", "San Miguel"});
            countryToCities.put("Equatorial Guinea", new String[]{"Malabo", "Bata", "Ebebiyin"});
            countryToCities.put("Eritrea", new String[]{"Asmara", "Keren", "Massawa"});
            countryToCities.put("Estonia", new String[]{"Tallinn", "Tartu", "Narva"});
            countryToCities.put("Eswatini", new String[]{"Mbabane", "Manzini", "Lobamba"});
            countryToCities.put("Ethiopia", new String[]{"Addis Ababa", "Dire Dawa", "Mek'ele"});
            countryToCities.put("Fiji", new String[]{"Suva", "Nadi", "Lautoka"});
            countryToCities.put("Finland", new String[]{"Helsinki", "Espoo", "Tampere"});
            countryToCities.put("France", new String[]{"Paris", "Marseille", "Lyon"});
            countryToCities.put("Gabon", new String[]{"Libreville", "Port-Gentil", "Franceville"});
            countryToCities.put("Gambia", new String[]{"Banjul", "Serekunda", "Brikama"});
            countryToCities.put("Georgia", new String[]{"Tbilisi", "Batumi", "Kutaisi"});
            countryToCities.put("Germany", new String[]{"Berlin", "Munich", "Frankfurt"});
            countryToCities.put("Ghana", new String[]{"Accra", "Kumasi", "Tamale"});
            countryToCities.put("Greece", new String[]{"Athens", "Thessaloniki", "Patras"});
            countryToCities.put("Grenada", new String[]{"Saint George's", "Grenville", "Gouyave"});
            countryToCities.put("Guatemala", new String[]{"Guatemala City", "Mixco", "Villa Nueva"});
            countryToCities.put("Guinea", new String[]{"Conakry", "Nzérékoré", "Kindia"});
            countryToCities.put("Guinea-Bissau", new String[]{"Bissau", "Bafatá", "Gabú"});
            countryToCities.put("Guyana", new String[]{"Georgetown", "Linden", "New Amsterdam"});
            countryToCities.put("Haiti", new String[]{"Port-au-Prince", "Cap-Haïtien", "Gonaïves"});
            countryToCities.put("Honduras", new String[]{"Tegucigalpa", "San Pedro Sula", "Choloma"});
            countryToCities.put("Hungary", new String[]{"Budapest", "Debrecen", "Szeged"});
            countryToCities.put("Iceland", new String[]{"Reykjavik", "Kopavogur", "Hafnarfjordur"});
            countryToCities.put("India", new String[]{"Mumbai", "Delhi", "Bengaluru"});
            countryToCities.put("Indonesia", new String[]{"Jakarta", "Surabaya", "Bandung"});
            countryToCities.put("Iran", new String[]{"Tehran", "Mashhad", "Isfahan"});
            countryToCities.put("Iraq", new String[]{"Baghdad", "Basra", "Mosul"});
            countryToCities.put("Ireland", new String[]{"Dublin", "Cork", "Limerick"});
            countryToCities.put("Israel", new String[]{"Jerusalem", "Tel Aviv", "Haifa"});
            countryToCities.put("Italy", new String[]{"Rome", "Milan", "Naples"});
            countryToCities.put("Jamaica", new String[]{"Kingston", "Montego Bay", "Spanish Town"});
            countryToCities.put("Japan", new String[]{"Tokyo", "Osaka", "Nagoya"});
            countryToCities.put("Jordan", new String[]{"Amman", "Zarqa", "Irbid"});
            countryToCities.put("Kazakhstan", new String[]{"Almaty", "Nur-Sultan", "Shymkent"});
            countryToCities.put("Kenya", new String[]{"Nairobi", "Mombasa", "Kisumu"});
            countryToCities.put("Kiribati", new String[]{"Tarawa", "Betio", "Bikenibeu"});
            countryToCities.put("Korea, North", new String[]{"Pyongyang", "Hamhung", "Nampo"});
            countryToCities.put("Korea, South", new String[]{"Seoul", "Busan", "Incheon"});
            countryToCities.put("Kuwait", new String[]{"Kuwait City", "Al Ahmadi", "Hawally"});
            countryToCities.put("Kyrgyzstan", new String[]{"Bishkek", "Osh", "Jalal-Abad"});
            countryToCities.put("Laos", new String[]{"Vientiane", "Pakse", "Savannakhet"});
            countryToCities.put("Latvia", new String[]{"Riga", "Daugavpils", "Liepaja"});
            countryToCities.put("Lebanon", new String[]{"Beirut", "Tripoli", "Sidon"});
            countryToCities.put("Lesotho", new String[]{"Maseru", "Teyateyaneng", "Mafeteng"});
            countryToCities.put("Liberia", new String[]{"Monrovia", "Gbarnga", "Kakata"});
            countryToCities.put("Libya", new String[]{"Tripoli", "Benghazi", "Misrata"});
            countryToCities.put("Liechtenstein", new String[]{"Vaduz", "Schaan", "Balzers"});
            countryToCities.put("Lithuania", new String[]{"Vilnius", "Kaunas", "Klaipeda"});
            countryToCities.put("Luxembourg", new String[]{"Luxembourg City", "Esch-sur-Alzette", "Differdange"});
            countryToCities.put("Madagascar", new String[]{"Antananarivo", "Toamasina", "Antsirabe"});
            countryToCities.put("Malawi", new String[]{"Lilongwe", "Blantyre", "Mzuzu"});
            countryToCities.put("Malaysia", new String[]{"Kuala Lumpur", "George Town", "Ipoh"});
            countryToCities.put("Maldives", new String[]{"Malé", "Addu City", "Fuvahmulah"});
            countryToCities.put("Mali", new String[]{"Bamako", "Sikasso", "Mopti"});
            countryToCities.put("Malta", new String[]{"Valletta", "Birkirkara", "Mosta"});
            countryToCities.put("Marshall Islands", new String[]{"Majuro", "Ebeye", "Rongelap"});
            countryToCities.put("Mauritania", new String[]{"Nouakchott", "Nouadhibou", "Rosso"});
            countryToCities.put("Mauritius", new String[]{"Port Louis", "Beau Bassin-Rose Hill", "Vacoas"});
            countryToCities.put("Mexico", new String[]{"Mexico City", "Guadalajara", "Monterrey"});
            countryToCities.put("Micronesia", new String[]{"Palikir", "Weno", "Tofol"});
            countryToCities.put("Moldova", new String[]{"Chisinau", "Tiraspol", "Balti"});
            countryToCities.put("Monaco", new String[]{"Monaco"});
            countryToCities.put("Mongolia", new String[]{"Ulaanbaatar", "Erdenet", "Darkhan"});
            countryToCities.put("Montenegro", new String[]{"Podgorica", "Nikšić", "Herceg Novi"});
            countryToCities.put("Morocco", new String[]{"Rabat", "Casablanca", "Marrakesh"});
            countryToCities.put("Mozambique", new String[]{"Maputo", "Beira", "Nampula"});
            countryToCities.put("Myanmar", new String[]{"Naypyidaw", "Yangon", "Mandalay"});
            countryToCities.put("Namibia", new String[]{"Windhoek", "Rundu", "Walvis Bay"});
            countryToCities.put("Nauru", new String[]{"Yaren", "Baiti", "Buada"});
            countryToCities.put("Nepal", new String[]{"Kathmandu", "Pokhara", "Lalitpur"});
            countryToCities.put("Netherlands", new String[]{"Amsterdam", "Rotterdam", "The Hague"});
            countryToCities.put("New Zealand", new String[]{"Auckland", "Wellington", "Christchurch"});
            countryToCities.put("Nicaragua", new String[]{"Managua", "León", "Masaya"});
            countryToCities.put("Niger", new String[]{"Niamey", "Zinder", "Maradi"});
            countryToCities.put("Nigeria", new String[]{"Lagos", "Abuja", "Kano"});
            countryToCities.put("North Macedonia", new String[]{"Skopje", "Bitola", "Kumanovo"});
            countryToCities.put("Norway", new String[]{"Oslo", "Bergen", "Trondheim"});
            countryToCities.put("Oman", new String[]{"Muscat", "Salalah", "Sohar"});
            countryToCities.put("Pakistan", new String[]{"Karachi", "Lahore", "Faisalabad"});
            countryToCities.put("Palau", new String[]{"Ngerulmud", "Koror", "Melekeok"});
            countryToCities.put("Panama", new String[]{"Panama City", "Colón", "David"});
            countryToCities.put("Papua New Guinea", new String[]{"Port Moresby", "Lae", "Arawa"});
            countryToCities.put("Paraguay", new String[]{"Asunción", "Ciudad del Este", "San Lorenzo"});
            countryToCities.put("Peru", new String[]{"Lima", "Arequipa", "Trujillo"});
            countryToCities.put("Philippines", new String[]{"Manila", "Quezon City", "Caloocan"});
            countryToCities.put("Poland", new String[]{"Warsaw", "Kraków", "Łódź"});
            countryToCities.put("Portugal", new String[]{"Lisbon", "Porto", "Braga"});
            countryToCities.put("Qatar", new String[]{"Doha", "Al Rayyan", "Umm Salal Muhammad"});
            countryToCities.put("Romania", new String[]{"Bucharest", "Cluj-Napoca", "Timișoara"});
            countryToCities.put("Russia", new String[]{"Moscow", "Saint Petersburg", "Novosibirsk"});
            countryToCities.put("Rwanda", new String[]{"Kigali", "Butare", "Gitarama"});
            countryToCities.put("Saint Kitts and Nevis", new String[]{"Basseterre", "Charlestown"});
            countryToCities.put("Saint Lucia", new String[]{"Castries", "Vieux Fort", "Soufrière"});
            countryToCities.put("Saint Vincent and the Grenadines", new String[]{"Kingstown", "Georgetown"});
            countryToCities.put("Samoa", new String[]{"Apia", "Vaitele"});
            countryToCities.put("San Marino", new String[]{"San Marino"});
            countryToCities.put("Sao Tome and Principe", new String[]{"São Tomé"});
            countryToCities.put("Saudi Arabia", new String[]{"Riyadh", "Jeddah", "Mecca"});
            countryToCities.put("Senegal", new String[]{"Dakar", "Touba", "Thiès"});
            countryToCities.put("Serbia", new String[]{"Belgrade", "Novi Sad", "Niš"});
            countryToCities.put("Seychelles", new String[]{"Victoria"});
            countryToCities.put("Sierra Leone", new String[]{"Freetown", "Bo", "Kenema"});
            countryToCities.put("Singapore", new String[]{"Singapore"});
            countryToCities.put("Slovakia", new String[]{"Bratislava", "Košice", "Prešov"});
            countryToCities.put("Slovenia", new String[]{"Ljubljana", "Maribor", "Celje"});
            countryToCities.put("Solomon Islands", new String[]{"Honiara"});
            countryToCities.put("Somalia", new String[]{"Mogadishu", "Hargeisa", "Bosaso"});
            countryToCities.put("South Africa", new String[]{"Pretoria", "Cape Town", "Johannesburg"});
            countryToCities.put("South Sudan", new String[]{"Juba", "Malakal", "Wau"});
            countryToCities.put("Spain", new String[]{"Madrid", "Barcelona", "Valencia"});
            countryToCities.put("Sri Lanka", new String[]{"Colombo", "Kandy", "Galle"});
            countryToCities.put("Sudan", new String[]{"Khartoum", "Omdurman", "Port Sudan"});
            countryToCities.put("Suriname", new String[]{"Paramaribo", "Lelydorp"});
            countryToCities.put("Sweden", new String[]{"Stockholm", "Gothenburg", "Malmö"});
            countryToCities.put("Switzerland", new String[]{"Zürich", "Geneva", "Basel"});
            countryToCities.put("Syria", new String[]{"Damascus", "Aleppo", "Homs"});
            countryToCities.put("Taiwan", new String[]{"Taipei", "Kaohsiung", "Taichung"});
            countryToCities.put("Tajikistan", new String[]{"Dushanbe", "Khujand", "Kulob"});
            countryToCities.put("Tanzania", new String[]{"Dodoma", "Dar es Salaam", "Mwanza"});
            countryToCities.put("Thailand", new String[]{"Bangkok", "Nonthaburi", "Chiang Mai"});
            countryToCities.put("Timor-Leste", new String[]{"Dili", "Baucau"});
            countryToCities.put("Togo", new String[]{"Lomé", "Sokodé", "Kara"});
            countryToCities.put("Tonga", new String[]{"Nuku'alofa"});
            countryToCities.put("Trinidad and Tobago", new String[]{"Port of Spain", "San Fernando", "Chaguanas"});
            countryToCities.put("Tunisia", new String[]{"Tunis", "Sfax", "Sousse"});
            countryToCities.put("Turkey", new String[]{"Ankara", "Istanbul", "Izmir"});
            countryToCities.put("Turkmenistan", new String[]{"Ashgabat", "Türkmenabat", "Daşoguz"});
            countryToCities.put("Tuvalu", new String[]{"Funafuti"});
            countryToCities.put("Uganda", new String[]{"Kampala", "Gulu", "Lira"});
            countryToCities.put("Ukraine", new String[]{"Kyiv", "Kharkiv", "Odessa"});
            countryToCities.put("United Arab Emirates", new String[]{"Abu Dhabi", "Dubai", "Sharjah"});
            countryToCities.put("United Kingdom", new String[]{"London", "Birmingham", "Manchester"});
            countryToCities.put("United States", new String[]{"New York", "Los Angeles", "Chicago"});
            countryToCities.put("Uruguay", new String[]{"Montevideo", "Salto", "Ciudad de la Costa"});
            countryToCities.put("Uzbekistan", new String[]{"Tashkent", "Samarkand", "Namangan"});
            countryToCities.put("Vanuatu", new String[]{"Port Vila", "Luganville"});
            countryToCities.put("Vatican City", new String[]{"Vatican City"});
            countryToCities.put("Venezuela", new String[]{"Caracas", "Maracaibo", "Valencia"});
            countryToCities.put("Vietnam", new String[]{"Hanoi", "Ho Chi Minh City", "Da Nang"});
            countryToCities.put("Yemen", new String[]{"Sana'a", "Aden", "Taiz"});
            countryToCities.put("Zambia", new String[]{"Lusaka", "Kitwe", "Ndola"});
            countryToCities.put("Zimbabwe", new String[]{"Harare", "Bulawayo", "Chitungwiza"});
            // Add other countries and their cities

            // Inserting data for each country and its cities
            for (String country : countries) {
                // Escape single quotes in country name
                String escapedCountry = country.replace("'", "''");

                // Check if the country already exists
                String checkCountryQuery = String.format("SELECT country_id FROM country WHERE name = '%s'", escapedCountry);
                ResultSet resultSet = statement.executeQuery(checkCountryQuery);
                Long countryId = null;
                if (resultSet.next()) {
                    countryId = resultSet.getLong("country_id");
                } else {
                    // If the country does not exist, insert it
                    String insertCountryQuery = String.format("INSERT INTO country (name) VALUES ('%s')", escapedCountry);
                    statement.executeUpdate(insertCountryQuery, Statement.RETURN_GENERATED_KEYS);
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        countryId = generatedKeys.getLong(1);
                        System.out.println("Inserted country: " + country);
                    }
                }

                if (countryId != null && countryToCities.containsKey(country)) {
                    String[] cities = countryToCities.get(country);
                    for (String city : cities) {
                        // Escape single quotes in city name
                        String escapedCity = city.replace("'", "''");

                        // Check if the city already exists
                        String checkCityQuery = String.format("SELECT COUNT(*) AS count FROM cities WHERE name = '%s' AND country_id = %d", escapedCity, countryId);
                        ResultSet cityResultSet = statement.executeQuery(checkCityQuery);
                        cityResultSet.next();
                        int cityCount = cityResultSet.getInt("count");

                        if (cityCount == 0) {
                            // If the city does not exist, insert it
                            String insertCityQuery = String.format("INSERT INTO cities (name, country_id) VALUES ('%s', %d)", escapedCity, countryId);
                            statement.executeUpdate(insertCityQuery);
                            System.out.println("Inserted city: " + city + " in country: " + country);
                        } else {
                            // System.out.println("City already exists: " + city + " in country: " + country);
                        }
                    }
                }
            }

            System.out.println("Data initialization completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
