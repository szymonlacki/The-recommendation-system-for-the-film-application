//package pl.example.netflix.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//import pl.example.netflix.model.*;
//import pl.example.netflix.springapp.dao.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Component
//public class DataLoader implements ApplicationRunner {
//    private final MovieDao movieDAO;
//    private final ActorDao actorDAO;
//    private final AccountDao accountDAO;
//    private final UserDetailDao userDetailDao;
//    private final GenreDao genreDao;
//
//    @Autowired
//    public DataLoader(MovieDao movieDAO, ActorDao actorDAO, AccountDao accountDAO, UserDetailDao userDetailDao, GenreDao genreDao) {
//        this.movieDAO = movieDAO;
//        this.actorDAO = actorDAO;
//        this.accountDAO = accountDAO;
//        this.userDetailDao = userDetailDao;
//        this.genreDao = genreDao;
//
//    }
//
//    public void run(ApplicationArguments args) {
//        try {
////            List<Movie> movies = loadMovies();
//            List<Actor> actors = loadActors();
////            List<UserDetail> userDetails = loadUserDetails();
////            List<Account> accounts = loadAccounts(userDetails);
//            List<Genre> genres = loadGenres();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    private List<Genre> loadGenres() throws Exception {
//        List<Genre> genres = new ArrayList<>();
//        genres.add(genreDao.save(new Genre("Akcja")));
//        genres.add(genreDao.save(new Genre("Animacja")));
//        genres.add(genreDao.save(new Genre("Dokumentalny")));
//        genres.add(genreDao.save(new Genre("Dramat")));
//        genres.add(genreDao.save(new Genre("Familijny")));
//        genres.add(genreDao.save(new Genre("Horror")));
//        genres.add(genreDao.save(new Genre("Komedia")));
//        genres.add(genreDao.save(new Genre("Kryminał")));
//        genres.add(genreDao.save(new Genre("Melodramat")));
//        genres.add(genreDao.save(new Genre("Przygodowy")));
//        genres.add(genreDao.save(new Genre("Romans")));
//        genres.add(genreDao.save(new Genre("Fantasy")));
//        genres.add(genreDao.save(new Genre("Sci-Fi")));
//        genres.add(genreDao.save(new Genre("Thriller")));
//
//        return genres;
//    }
//
//
////    private List<UserDetail> loadUserDetails() throws Exception {
////        List<UserDetail> userDetails = new ArrayList<>();
////        userDetails.add(userDetailDao.save(new UserDetail("Szymon Łącki","szymon96@gmil.com","4")));
////        userDetails.add(userDetailDao.save(new UserDetail("Marcin Kowalski","marcin@o2.pl","18")));
////        return userDetails;
////    }
////    private List<Movie> loadMovies() throws Exception {
////        List<Movie> movies = new ArrayList<>();
////        movies.add(movieDAO.save(new Movie("222222222","16-09-2015","2015","240min","PL","//upload.wikimedia.org/wikipedia/en/thumb/8/8f/Fast_and_Furious_Poster.jpg/220px-Fast_and_Furious_Poster.jpg","Poland","sdf")));
////
////        movies.add(movieDAO.save(new Movie("M jak miłość","16-09-2015","2015","240min","PL","//upload.wikimedia.org/wikipedia/en/thumb/8/8f/Fast_and_Furious_Poster.jpg/220px-Fast_and_Furious_Poster.jpg","Poland","dsfsd")));
////        return movies;
////    }
//
//    private List<Actor> loadActors() throws Exception {
//
//        List<Actor> actors = new ArrayList<>();
//        actors.add(actorDAO.save(new Actor("Tom Hanks", "09.07.1956", "USA", "Mężczyzna", "Tom Hanks.jpg", "Thomas Jeffrey \"Tom\" Hanks (born July 9, 1956) is an American actor, producer, writer and director. Hanks worked in television and family-friendly comedies, gaining wide notice in 1988's Big, before achieving success as a dramatic actor in several notable roles, including Andrew Beckett in Philadelphia, the title role in Forrest Gump, Commander James A. Lovell in Apollo 13, Captain John H. Miller in Saving Private Ryan, Joe Fox in You've Got Mail and Chuck Noland in Cast Away. Hanks won consecutive Best Actor Academy Awards, in 1993 for Philadelphia and in 1994 for Forrest Gump. U.S. domestic box office totals for his films exceed $3.9 billion.")));
//        actors.add(actorDAO.save(new Actor("Michael Clarke Duncan", "10.12.1957", "USA", "Mężczyzna", "Michael Clarke Duncan.jpg ", "Michael Clarke Duncan urodził się 10 grudnia 1957 roku w Chicago w stanie Illinois. Jest najbardziej znany ze swojej przełomowej roli jako John Coffey w The Green Mile. W 1998 r. Duncan został obsadzony jako Niedźwiedź w filmie Armageddon, gdzie nawiązał przyjaźń z obsadą Brucem Willisem. To wpływy Bruce'a Willisa pomogły mu uzyskać przełomową rolę jako John Coffey w reżyserii Franka Darabonta The Green Mile, rola, która przyniosła mu nominację do Oscara w kategorii najlepszego aktora drugoplanowego i nominację do Złotego Globu w kategorii Best Występ aktora w roli drugoplanowej w filmie. Duncan został następnie obsadzony w szeregu filmów, które pomogły mu ustanowić go jako gwiazdę: The Whole Nine Yards, Planet of the Apes, The Scorpion King (gdzie zagrał u boku jego przyjaciela, The Rock), The Island i Daredevil jako Wilson Fisk , znany też jako The Kingpin..")));
//        actors.add(actorDAO.save(new Actor("David Morse", "11.10.1953", "USA", "Mężczyzna", "David Morse.jpg", "David Bowditch Morse (ur. 11 października 1953) jest amerykańskim aktorem teatralnym, telewizyjnym i filmowym. Po raz pierwszy zwrócił na siebie uwagę narodową jako Dr Jack Morrison w dramacie medycznym St. Elsewhere w latach 1982-1988. Morse kontynuował karierę filmową, występując w: Dancer in the Dark, Negotiator, The Green Mile, Disturbia, The Long Kiss Goodnight, The Crossing Guard, The Rock, Extreme Measures, Dwanaście małp, 16 bloków i HounddogW 2006 r. Morse miał powtarzającą się rolę detektywa Michaela Trittera w dramacie medycznym House, za który otrzymał nominację do nagrody Emmy. Morse przedstawił George'a Washingtona w miniserialu HBO 2008 Johna Adamsa, który przyniósł mu drugą nominację do nagrody Emmy...")));
//        actors.add(actorDAO.save(new Actor("Bonnie Hunt", "22.09.1961", "USA", "Kobieta", "Bonnie Hunt.jpg", "Bonnie Lynne Hunt (ur. 22 września 1961 r.) Jest amerykańską aktorką, komikiem, pisarką, reżyserem, producentem telewizyjnym i dzienną stacją telewizyjną")));
//        actors.add(actorDAO.save(new Actor("Helen Hunt", "16.06.1963", "USA", "Kobieta", "Helen Hunt.jpg", "Helen Elizabeth Hunt (ur. 15 czerwca 1963 r.) Jest amerykańską aktorką, reżyserką i scenarzystką. Zagrała w sitcomie Mad About You przez siedem lat, zanim została obsadzona w komedii romantycznej \"Tak dobrze, jak to jest\" (za którą zdobyła Oscara dla najlepszej aktorki) i \"Klątwa Jadeńskiego Skorpiona\". Niektóre z jej innych filmów w Hollywood to Twister, Cast Away, What Women Want i Pay It Forward. Debiut reżyserski zadebiutowała w 2007 roku filmem \"Ona mnie znalazła ...")));
//        actors.add(actorDAO.save(new Actor("Chris Noth", "13.11.1954", "USA", "Mężczyzna", "Chris Noth.jpg", "Chris Noth jest amerykańskim aktorem teatralnym i filmowym, najbardziej znanym z roli detektywa Mike'a Logana w \"Law & Order\" i \"Law & Order: Criminal Intent\", jako Mr. Big w \"Sex and the City\" oraz jako Peter Florrick w serialu CBS \"The Good Wife\".")));
//        actors.add(actorDAO.save(new Actor("Cezary Pazura", "13.06.1962", "Polska", "Mężczyzna", "Cezary Pazura.jpg", "Zamiłowanie do aktorstwa odziedziczył po ojcu, który z dużymi sukcesami występował w teatrze amatorskim. Cezary Pazura ukończył szkołę muzyczną  w klasie klarnetu i fortepianu i postanowił zdawać do Państwowej Wyższej Szkoły Filmowej, Telewizyjnej i Teatralnej im. Leona Schillera w Łodzi. Za pierwszym razem mu się nie powiodło, ale druga próba była już udana. Ukończył ją w 1986 roku.  Początkowo grywał niewielkie role, ale po kreacji w \"Krollu\" Władysława Pasikowskiego z dnia na dzień stał się gwiazdą. W 1997 roku wystąpił w filmie, który okazał się być jednym z największych przebojów rodzimego kina: \"Kiler\" Juliusza Machulskiego. W 2007 roku debiutował jako reżyser kręcąc 23 odcinek serialu \"Faceci do wzięcia\" (\"Sen sprawiedliwych\"), a w 2010 roku stworzył swój pierwszy film pełnometrażowy pt. \"Weekend\". 16 października 1998 roku odsłonięto gwiazdę aktora w Alei Gwiazd w Łodzi.")));
//        actors.add(actorDAO.save(new Actor("Janusz Rewiński", "06.09.1949", "Polska", "Mężczyzna", "Janusz Rewiński.jpg", "Charakterystyczny aktor komediowy i satyryk. W 1972 r. ukończył krakowską PWST. Przed kamerami wystąpił jednak po raz pierwszy dopiero w 1983 r. w filmie \"Sny i marzenia\". Popularność przyniosły mu role w takich filmach jak \"Podróże Pana Kleksa\", Uprowadzenie Agaty\" i oczywiście \"Kiler\". Przez długie lata Rewiński zajmował się głównie działalnością kabaretową. Był współtwórcą słynnych Skautów Piwnych a także Polskiej Partii Przyjaciół Piwa.")));
//        actors.add(actorDAO.save(new Actor("Jerzy Stuhr", "18.04.1947", "Polska", "Mężczyzna",  "Jerzy Stuhr.jpg", "Jest jednym z najwybitniejszych i najpopularniejszych aktorów polskich. W 1972 r. ukończył krakowską PWST i został zaangażowany do pracy w Teatrze Starym, z którym pozostał związany aż do 1991 r. Jerzy Stuhr jest laureatem wielu prestiżowych nagród zarówno za role sceniczne jak i filmowe. W latach 80. występował we Włoszech i za wspaniałe opanowanie języka włoskiego i jakość interpretacji w 1982 r. otrzymał nagrodę krytyki za pracę aktora zagranicznego w Italii. Artysta jest wykładowcą w krakowskiej PWST a w latach 1991-96 był rektorem tej uczelni. W 1994 r. Stuhr zadebiutował po drugiej stronie kamery reżyserując film \"Spis cudzołożnic\". Obraz spotkał…")));
//        actors.add(actorDAO.save(new Actor("Małgorzata Kożuchowska", "27.04.1971", "Polska", "Kobieta", "Małgorzata Kożuchowska.jpg", "Małgorzata Kożuchowska urodziła się we Wrocławiu w 1971 roku. W 1994 roku została absolwentką warszawskiej PWST i od tego czasu występowała w Teatrze Dramatycznym w Warszawie. Zagrała m.in. w \"Magii grzechu\", \"Jak wam się podoba\", w \"Operze żebraczej\", w \"Poskromieniu złośnicy\", w spektaklu \"Obsługiwałem angielskiego króla\", w \"Tonacji blue, czyli Blue Room\" (2000), współpracując z wieloma wybitnymi reżyserami. W roku 2000 wystąpiła w irlandzkim w spektaklu \"It Come Up Sun\" w reżyserii Paula Merciera. Od 2005 roku jest aktorką Teatru Narodowego w Warszawie, gdzie zagrała w \"Błądzeniu\" (jeszcze gościnnie w 2004 r.) i \"Kosmosie\" (2005)...")));
//        actors.add(actorDAO.save(new Actor("Maciej Stuhr", "23.06.1975", "Polska", "Mężczyzna",  "Maciej Stuhr.jpg", "Polski aktor filmowy i teatralny, współzałożyciel kabaretu Po Żarcie, od 2008 aktor Nowego Teatru w Warszawie. Z wykształcenia jest psychologiem oraz aktorem.")));
//        actors.add(actorDAO.save(new Actor("Michał Milowicz", "16.09.1970", "Polska", "Mężczyzna", "Michał Milowicz.jpg", "Na co dzień kompozytor - piosenkarz i aktor warszawskiego Teatru Studio Buffo. Jest pomysłodawcą, współtwórcą i tytułowym bohaterem przedstawienia \"Koncert piosenek Elvisa Presleya\", które przyniosło mu opinię jednego z najwszechstronniejszych talentów obecnego składu teatru Studio Buffo. Milowicz występował również we wcześniejszych przedstawieniach tego teatru: \"Metro\", \"Do grającej szafy grosik wrzuć II\". Później mogliśmy zobaczyć go w \"Killerach 2-óch\" oraz w serialu TV \"Klan\".")));
//        actors.add(actorDAO.save(new Actor("Mirosław Zbrojewicz", "25.02.1957", "Polska", "Mężczyzna",  "Mirosław Zbrojewicz.jpg", "Mirosław Zbrojewicz urodził się 25 lutego 1957r. w Warszawie. W 1981 roku ukończył studia w warszawskiej PWST. Swój debiut teatralny miał 14 czerwca 1981r., wystąpił wówczas w roli Sukiennika w \"Mistrzu Piotrze Pathelinie\" w reżyserii Wojciecha Maryańskiego na scenie Lubuskiego Teatru im. L. Kruczkowskiego w Zielonej Górze. Jednak na dużym ekranie zadebiutował dopiero w 1989r. jako Strażak w \"Ostatnim dzwonku\". Dużą popularność przyniosły mu role w polskich komediach, np. jako człowiek Siary w \"Kilerze\" oraz jako kultowy Andrzej \"Grucha\" w filmie \"Chłopaki nie płaczą\". Mirosław Zbrojewicz zajmuje się również dubbingiem. Użyczył głosu m.in. Wilkowi w \"Shreku\" oraz braciom Karczybykom w \"Zaplątanych\".")));
//        actors.add(actorDAO.save(new Actor("Steve Carell", "16.08.1962", "USA", "Mężczyzna", "Steve Carell.jpg", "Steven John \"Steve\" Carell (ur. 16 sierpnia 1962) jest amerykańskim aktorem, komikiem, artystą głosowym, producentem, reżyserem i pisarzem. Carell zasłynął z ról w telewizyjnym serialu The Daily Show z Jonem Stewartem w latach 1999-2004 oraz The Office od 2005 roku. Zagrał także w kilku hollywoodzkich filmach, w tym w filmie \"Anorman\", \"The 40-Year-Old Virgin\", \"Little Miss Sunshine\", \"Evan Wszechmogący\", \"Dan w prawdziwym życiu\", \"Zyskać mądrość\", \"Data wieczoru\" i \"Kolacja\" dla Schmucksa; i dźwięczne postacie w filmach animowanych \"Over the Hedge\", \"Horton Hear a Who!\" i \"Despicable Me\". Carell został nominowany jako \"najzabawniejszy człowiek Ameryki\" w magazynie Life. Otrzymał Złoty Glob ...")));
//        actors.add(actorDAO.save(new Actor("Julianne Moore", "03.12.1960", "USA", "Kobieta","Julianne Moore.jpg", "Julianne Moore (ur. Julie Anne Smith, 3 grudnia 1960) jest amerykańską aktorką i autorką książek dla dzieci. W trakcie swojej kariery była nominowana do czterech Oscarów, sześciu Złotych Globów, trzech BAFTA i dziewięciu nagród Screen Actors Guild. Moore rozpoczęła karierę aktorską w 1983 r. W niewielkich rolach, zanim dołączyła do obsady opery mydlanej As the World Turns, za którą zdobyła nagrodę Daytime Emmy w 1988 r. Zaczęła pojawiać się w rolach drugoplanowych w filmach we wczesnych latach 90-tych, w filmy takie jak The Hand That Rocks the Cradle i The Fugitive. Jej występ w Short Cuts (1993) zdobył ją i reszta obsady Złotego Globu za występ zespołu i jej ...")));
//        actors.add(actorDAO.save(new Actor("Ryan Gosling", "12.11.1980", "Kanada", "Mężczyzna", "Ryan Gosling.jpg", "Ryan Thomas Gosling (ur. 12 listopada 1980 r.) Jest kanadyjskim aktorem, muzykiem, działaczem społecznym i producentem. Gosling zaczął występować w wieku 12 lat w amerykańskim programie telewizyjnym The Mickey Mouse Club. W wieku 17 lat Gosling został obsadzony jako Sean w kanadyjskiej telewizji krótkometrażowej Breaker High (1997-1998). Po swoim debiutanckim filmie pełnometrażowym w \"Remember the Titans\" (2000), Gosling miał swoją przełomową rolę jako fanatyczny neonazista w dramacie z 2001 r. The Believer, za który otrzymał nominację do nagrody Independent Spirit Awards dla najlepszego męskiego ...")));
//        actors.add(actorDAO.save(new Actor("Emma Stone", "06.11.1988", "USA", "Kobieta", "Emma Stone.jpg", "Emily Jean \"Emma\" Stone jest amerykańską aktorką najbardziej znaną ze swojego stylu aktorskiego, husky i rudych włosów. Urodziwszy się w Arizonie, w wieku 15 lat porzuciła szkołę średnią, by przenieść się do Hollywood i ścigać aktorstwo. Choć naturalnie blondynka, jej pierwsza rola kiedykolwiek wylądowała po tym, jak umarła jej włosa brunetka, a ostatecznie czerwona przez reżysera Judd Apatow za jej przełomową rolę w Superbad. Jej zauważalny niski głos jest efektem ubocznym nieustannego krzyczenia dziecka.")));
//        actors.add(actorDAO.save(new Actor("Jesse Eisenberg", "05.10.1983", "Nowy Jork", "Mężczyzna", "Jesse Eisenberg.jpg", "Jesse Adam Eisenberg (ur. 5 października 1983 r.) Jest amerykańskim aktorem, autorem i dramaturgiem. Zadebiutował w telewizji krótkometrażowym serialem komediowym Get Real (1999-2000). Po swojej pierwszej roli głównej w komediodramacie Roger Dodger (2002) pojawił się w dramacie The Emperor's Club (2002), thrillerze psychologicznym The Village (2004), komediodramacie The Squid and the Whale (2005) oraz film o dramacie The Education of Charlie Banks (2007) ...")));
//        actors.add(actorDAO.save(new Actor("Mark Ruffalo", "22.11.1967", "USA", "Mężczyzna", "Mark Ruffalo.jpg", "Mark Alan Ruffalo (ur. 22 listopada 1967) jest amerykańskim aktorem, reżyserem, producentem i scenarzystą. Pracował w filmach: Eternal Sunshine od Spotless Mind, Zodiac, Shutter Island, Just Like Heaven, Możesz na mnie liczyć i The Kids Are All Right, za który otrzymał nominację do Oscara dla najlepszego aktora drugoplanowego.")));
//        actors.add(actorDAO.save(new Actor("Woody Harrelson", "23.07.1961", "USA", "Mężczyzna", "Woody Harrelson.jpg", "Woodrick Tracy \"Woody\" Harrelson (ur. 23 lipca 1961) jest amerykańskim aktorem i komikiem. Przełomowa rola Harrelsona pojawiła się w sitcomie telewizyjnym Cheers jako barman Woody Boyd. Znani bohaterowie filmowi to między innymi Billy Hoyle z koszykówki w White Men Can not Jump, melonik Roy Munson w Kingpin, seryjny morderca Mickey Knox w Natural Born Killers, wydawca magazynu Larry Flynt w The People vs. Larry Flynt, country Dusty in A Prairie Home Towarzysz, łowca nagród Carson Wells w żadnym kraju dla starców, zombie killer Tallahassee w Zombieland, ślepy pianista / sprzedawca mięsa Ezra Turner w Seven Pounds, orzech konspiracyjny Charlie Frost w 2012 roku, ...")));
//        actors.add(actorDAO.save(new Actor("Matthew McConaughey", "04.11.1969", "USA", "Mężczyzna","Matthew McConaughey.jpg", "Matthew David McConaughey (ur. 4 listopada 1969) jest amerykańskim aktorem. Po serii mniejszych ról we wczesnych latach dziewięćdziesiątych McConaughey otrzymał informację o swojej przełomowej roli w Dazed and Confused (1993). Właśnie w tej roli po raz pierwszy wpadł na pomysł jego hasła \"Dobrze, dobrze\". Następnie pojawił się w filmach takich jak A Time to Kill, Contact, U-571, Tiptoes, Sahara i We Are Marshall. McConaughey najbardziej znany jest ostatnio ze swoich występów jako czołowy aktor w komediach romantycznych Planowanie ślubu, Jak stracić faceta w 10 dni, Niepowodzenie startu, Ghosts of Girlfriends Past i Fool's Gold ...")));
//        actors.add(actorDAO.save(new Actor("Leonardo DiCaprio", "11.11.1974", "USA", "Mężczyzna", "Leonardo DiCaprio.jpg", "Leonardo Wilhelm DiCaprio (ur. 11 listopada 1974 r.) Jest amerykańskim aktorem, producentem filmowym i działaczem na rzecz ochrony środowiska.\n" +
//                "\n" +
//                "Rozpoczął karierę filmową, występując jako Josh w Critters 3, a następnie zagrał w filmowej adaptacji wspomnień This Boy's Life (1993) wraz z Robertem De Niro. DiCaprio był chwalony za rolę drugoplanową w dramacie Co jemy Gilbert Grape (1993) i zyskał publiczne uznanie dzięki wiodącym rolom w dramacie The Basketball Diaries (1995) i romantycznym dramacie Romeo + Juliet (1996) ...")));
//        actors.add(actorDAO.save(new Actor("Jonah Hill", "20.12.1983", "USA", "Mężczyzna",  "Jonah Hill.jpg", "Jonah Hill Feldstein (ur. 20 grudnia 1983) jest amerykańskim aktorem, producentem, scenarzystą i komikiem. Hill jest znany z komediowych ról w filmach takich jak Accepted (2006), Babcia Boy (2006), Superbad (2007), Knocked Up (2007), Zapominając Sarah Marshall (2008), Zabierz go do Greka (2010), 21 Jump Street (2012), This Is the End (2013), 22 Jump Street (2014) i War Dogs (2016), a także jego występy w Moneyball (2011) i The Wolf of Wall Street (2013), dla których otrzymał nominacje do Oscara dla najlepszego aktora drugoplanowego ...")));
//        actors.add(actorDAO.save(new Actor("Margot Robbie", "02.07.1990", "Australia", "Kobieta", "Margot Robbie.jpg", "Margot Elise Robbie (ur. 2 lipca 1990 r.) Jest australijską aktorką i producentem filmowym. Jest znana z roli Donny Freedman w operze mydlanej Neighbours, która zdobyła dwie nominacje do nagrody Logie Award. W 2011 roku Robbie zaczął występować jako Laura Cameron w serialu telewizyjnym Pan Am Pan. Po odwołaniu Pan Am, Robbie pojawił się w filmach fabularnych O czasie (2013), Wilk z Wall Street (2013), Suicide Squad (2016) i wiele innych. W 2017 roku zagrała w filmie biograficznym I, Tonya, który zdobył wiele jej wyróżnień, w tym jej pierwszą nominację do Oscara. Od 2016 roku jest żoną brytyjskiego asystenta reżysera i producenta Toma ...")));
//        actors.add(actorDAO.save(new Actor("Patrick Wilson", "03.07.1973",  "USA", "Mężczyzna", "Patrick Wilson.jpg", "Patrick Joseph Wilson (ur. 3 lipca 1973) jest amerykańskim aktorem i piosenkarzem.\n" +
//                "\n" +
//                "Wilson spędził lata śpiewając główne role w głównych musicalach na Broadwayu, począwszy od 1996 roku. W 2003 roku pojawił się w mini-serialu HBO Aniołowie w Ameryce. Wilson wystąpił w ponad 18 filmach fabularnych, w tym w The Alamo (2004), The Phantom of the Opera (2004) z Emmy Rossum i Gerardem Butlerem, 2006 w filmie Małe dzieci (z Kate Winslet), w 2009 roku w filmie Watchmen, Film z 2010 r. Zespół A, a także film z 2011 r. The Ledge. On był…")));
//        actors.add(actorDAO.save(new Actor("Lili Taylor", "20.02.1967", "USA", "Kobieta", "Lili Taylor.jpg", "Lili Anne Taylor (ur. 20 lutego 1967 r., Wzrost 5 '2 \"(1,57 m)) to amerykańska aktorka znana z występów w takich nagradzanych indie, jak Mystic Pizza, Short Cuts i I Shot Andy Warhol.")));
//        actors.add(actorDAO.save(new Actor("Vera Farmiga", "06.08.1973", "USA", "Kobieta", "Vera Farmiga.jpg", "Vera Ann Farmiga (ur. 6 sierpnia 1973 r.) Jest amerykańską aktorką i reżyserką. Farmiga zadebiutowała w filmie w 1998 roku w thrillerze dramatycznym Powrót do raju. Następne były role drugoplanowe w filmie romantycznym z 2000 roku Jesień w Nowym Jorku i serialu telewizyjnym UC: Undercover z 2001 roku. Została również obsadzona w thrillerze z 2001 roku 15 minut. Inne role i role w filmie to komedia Dummy z 2003 r., Dramat z 2004 r. Down to the Bone, thriller kryminalny z 2006 r. The Departed, horror z 2007 r. Joshua oraz dramat z 2008 r. The Boy in the Striped Pyjamas. Farmiga zdobyła uznanie krytyków po pracy w komediodramacie Up in the Air z 2009 roku, dla którego była ...")));
//        actors.add(actorDAO.save(new Actor("Annabelle Wallis", "25.09.1984", "Wielka Brytania", "Kobieta","Annabelle Wallis.jpg", "Annabelle Frances Wallis (ur. 5 września 1984 r.) Jest angielską aktorką najbardziej znaną ze swoich ról: Jane Seymour w serialu dramatycznym Showtime The Tudors, Bridget Pierce w dramacie ABC Pan Am, Mia Form w nadprzyrodzonym horrorze Annabelle 2014, Grace Burgess w BBC dramat Peaky Blinders i Jenny Halsey w filmie akcji The Mummy 2017.")));
//        actors.add(actorDAO.save(new Actor("Ward Horton", "14.01.1976", "USA", "Mężczyzna","Ward Horton.jpg", "Ward Kirby Horton (amerykański 14 stycznia 1976) jest amerykańskim aktorem i kaskaderem. Najbardziej znany jest z roli Johna Forma w horrorze Annabelle i doktora Scotta Straussa w Pure Genius CBS.")));
//        actors.add(actorDAO.save(new Actor("Kate Winslet", "05.10.1975", "Wielka Brytania", "Kobieta", "Kate Winslet.jpg", "Kate Elizabeth Winslet (ur. 5 października 1975 r.) Jest angielską aktorką i piosenkarką. Otrzymała wiele nagród i nominacji. Jest najmłodszą osobą, która uzyskała sześć nominacji do Oscara i zdobyła Oscara dla najlepszej aktorki dla czytelnika (2008).\n" +
//                "\n" +
//                "Winslet został doceniony zarówno za twórczość dramatyczną, jak i komediową w projektach od filmów okresowych po współczesne, od wielkich hollywoodzkich produkcji po mniej znane filmy niezależne. Jest laureatką nagrody Screen Actors Guild, Brytyjskiej Akademii Sztuki Filmowej i Telewizyjnej oraz ...")));
//        actors.add(actorDAO.save(new Actor("Billy Zane", "24.02.1966", "USA", "Mężczyzna","Billy Zane.jpg", "William George \"Billy\" Zane, Jr. (ur. 24 lutego 1966) jest amerykańskim aktorem, producentem i reżyserem. Prawdopodobnie najbardziej znany jest z roli Caledona \"Cal\" Hockleya w Titanicu, The Phantom from The Phantom, Johna Wheelera w Twin Peaks i Mr. E in CQ.")));
//        actors.add(actorDAO.save(new Actor("Mike Myers", "25.05.1963", "Kanada", "Mężczyzna", "Mike Myers.jpg", "Michael John \"Mike\" Myers (ur. 25 maja 1963) jest kanadyjskim aktorem, komikiem, scenarzystą i producentem filmowym brytyjskiego pochodzenia. Był długoletnim członkiem obsady programu NBC Saturday Night Live pod koniec lat 80. i na początku lat 90. XX wieku. Wystąpił w roli głównej w filmach Wayne's World, Austin Powers i serialu filmów Shrek.")));
//        actors.add(actorDAO.save(new Actor("Eddie Murphy", "03.04.1961", "USA", "Mężczyzna", "Eddie Murphy.jpg", "Edward \"Eddie\" Regan Murphy (ur. 3 kwietnia 1961) jest amerykańskim aktorem, aktorem głosu, reżyserem filmowym, producentem, komikiem i piosenkarzem.\n" +
//                "\n" +
//                "Jest drugim najbardziej dochodowym aktorem w historii filmu. Był stałym członkiem obsady Saturday Night Live od 1980 do 1984 roku i pracował jako stand-up comedian. Zajął 10 miejsce na liście 100 najlepszych strojów wszechczasów Comedy Central. Otrzymał nominacje do Złotego Globu w kategorii Złoty Glob za nową gwiazdę roku - Aktor za ...")));
//        actors.add(actorDAO.save(new Actor("Cameron Diaz", "30.08.1972", "USA", "Kobieta","Cameron Diaz.jpg", "Cameron Michelle Diaz (ur. 30 sierpnia 1972 r.) - amerykańska aktorka i była modelka. W latach 90. zyskała rozgłos dzięki rolom w filmach \"Maska\", \"Ślub mojego najlepszego przyjaciela\" i \"Coś o Marii\". Inne ważne postacie to dwa filmy o Charlie's Angels, w których występuje postać księżniczki Fiony w serialu Shrek, Any Given Sunday, Knight and Day, The Holiday, The Green Hornet i Bad Teacher. Diaz została nominowana do czterech nominacji do Złotego Globu za role w filmach \"Być jak John Malkovich, Vanilla Sky, Gangs of New York\" i \"There's Something About Mary\", za które zdobyła nagrodę New York Film Critics ...")));
//
//
//        return actors;
//    }
//
////    private List<Account> loadAccounts(List<UserDetail> userDetails) throws Exception {
////
////        List<Account> accounts = new ArrayList<>();
////        accounts.add(accountDAO.save(new Account("admin","admin",userDetails.get(0),AccesRight.AccessRightEnum.CUSTOMER.getAccessRight())));
////        accounts.add(accountDAO.save(new Account("Marcin","1haslo2",userDetails.get(1),AccesRight.AccessRightEnum.CUSTOMER.getAccessRight())));
////        return accounts;
////    }
//
//}
