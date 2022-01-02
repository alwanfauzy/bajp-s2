package com.alwan.bajpsubmission2.data

import com.alwan.bajpsubmission2.R
import com.alwan.bajpsubmission2.data.model.Catalogue


object DummyCatalogue {
    fun getMovie(): ArrayList<Catalogue> {
        val listMovies = ArrayList<Catalogue>()

        listMovies.add(
            Catalogue(
                0,
                "Alita: Battle Angle",
                "When Alita awakens with no memory of who she is in a future world she does " +
                        "not recognize, she is taken in by Ido, a compassionate doctor who realizes " +
                        "that somewhere in this abandoned cyborg shell is the heart and soul of a " +
                        "young woman with an extraordinary past.",
                "Action, Science Fiction, Adventure",
                "71%",
                R.drawable.poster_alita
            )
        )

        listMovies.add(
            Catalogue(
                1,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an " +
                        "underwater kingdom ruled by the power-hungry King Orm. With a vast army at " +
                        "his disposal, Orm plans to conquer the remaining oceanic people and then " +
                        "the surface world. Standing in his way is Arthur Curry, Orms half-human, " +
                        "half-Atlantean brother and true heir to the throne.",
                "Action, Adventure, Fantasy",
                "69%",
                R.drawable.poster_aquaman
            )
        )

        listMovies.add(
            Catalogue(
                2,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass " +
                        "guitarist John Deacon take the music world by storm when they form the rock " +
                        " and roll band Queen in 1970. Hit songs become instant classics. When Mercury" +
                        " s increasingly wild lifestyle starts to spiral out of control, Queen soon " +
                        "faces its greatest challenge yet – finding a way to keep the band together " +
                        "amid the success and excess.", "Drama, Music",
                "80%",
                R.drawable.poster_bohemian
            )
        )

        listMovies.add(
            Catalogue(
                3,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering " +
                        "followers to his cause—elevating wizards above all non-magical beings. The " +
                        "only one capable of putting a stop to him is the wizard he once called his" +
                        " closest friend, Albus Dumbledore. However, Dumbledore will need to seek" +
                        "help from the wizard who had thwarted Grindelwald once before, his former " +
                        "student Newt Scamander, who agrees to help, unaware of the dangers that lie " +
                        "ahead. Lines are drawn as love and loyalty are tested, even among the truest" +
                        " friends and family, in an increasingly divided wizarding world.",
                "Adventure, Fantasy, Drama",
                "69%",
                R.drawable.poster_crimes
            )
        )

        listMovies.add(
            Catalogue(
                4,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses " +
                        "his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who" +
                        " has twenty-four personalities. Meanwhile, the shadowy presence of Elijah " +
                        "Price emerges as an orchestrator who holds secrets critical to both men.",
                "Thriller, Drama, Science Fiction",
                "66%",
                R.drawable.poster_glass
            )
        )

        listMovies.add(
            Catalogue(
                5,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ " +
                        "discovery of an untamed, elusive mate draws the Night Fury away. When danger" +
                        " mounts at home and Hiccup’s reign as village chief is tested, both dragon " +
                        "and rider must make impossible decisions to save their kind.",
                "Animation, Family, Adventure",
                "78%",
                R.drawable.poster_how_to_train
            )
        )

        listMovies.add(
            Catalogue(
                6,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from " +
                        "threats too large for any one hero to handle, a new danger has emerged from" +
                        " the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is " +
                        "to collect all six Infinity Stones, artifacts of unimaginable power, and " +
                        "use them to inflict his twisted will on all of reality. Everything the " +
                        "Avengers have fought for has led up to this moment - the fate of Earth and " +
                        "existence itself has never been more uncertain.",
                "Adventure, Action, Science Fiction",
                "83%",
                R.drawable.poster_infinity_war
            )
        )

        listMovies.add(
            Catalogue(
                7,
                "Overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall " +
                        "behind enemy lines after their aircraft crashes while on a mission to destroy" +
                        " a radio tower in a small village near the beaches of Normandy. After reaching" +
                        " their target, the surviving paratroopers realise that, in addition to fighting " +
                        "the Nazi troops that patrol the village, they also must fight against something else.",
                "Horror, War, Science Fiction",
                "67%",
                R.drawable.poster_overlord
            )
        )

        listMovies.add(
            Catalogue(
                8,
                "Ralph Breaks the Internet",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk " +
                        "it all by traveling to the World Wide Web in search of a replacement part " +
                        "to save Vanellopes video game, Sugar Rush. In way over their heads, Ralph " +
                        "and Vanellope rely on the citizens of the internet — the netizens — to help " +
                        "navigate their way, including an entrepreneur named Yesss, who is the head " +
                        "algorithm and the heart and soul of trend-making site BuzzzTube.",
                "Family, Animation, Comedy, Adventure",
                "72%",
                R.drawable.poster_ralph
            )
        )

        listMovies.add(
            Catalogue(
                9,
                "Spider-Man: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and " +
                        "being a spider-man. When Wilson Kingpin Fisk uses a super collider, others" +
                        " from across the Spider-Verse are transported to this dimension.",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "84%",
                R.drawable.poster_spiderman
            )
        )
        return listMovies
    }

    fun getTvShow(): ArrayList<Catalogue> {
        val listTvShow = ArrayList<Catalogue>()

        listTvShow.add(
            Catalogue(
                0,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a " +
                        "strange boy whom he named Goku. Gohan raised him and trained Goku in martial " +
                        "arts until he died. The young and very strong boy was on his own, but easily" +
                        " managed. Then one day, Goku met a teenage girl named Bulma, whose search for" +
                        " the mystical Dragon Balls brought her to Gokus home. Together, they set off" +
                        " to find all seven and to grant her wish.",
                "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
                "80%",
                R.drawable.poster_dragon_ball
            )
        )

        listTvShow.add(
            Catalogue(
                1,
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when" +
                        " visiting Harujion Town, she meets Natsu, a young man who gets sick easily" +
                        " by any type of transportation. But Natsu isnt just any ordinary kid, hes " +
                        "a member of one of the worlds most infamous mage guilds: Fairy Tail.",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                "75%",
                R.drawable.poster_fairytail
            )
        )

        listTvShow.add(
            Catalogue(
                2,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin Sweet animated series " +
                        "featuring the adventures of the dysfunctional Griffin family. Bumbling Peter" +
                        " and long-suffering Lois have three kids. Stewie (a brilliant but sadistic " +
                        "baby bent on killing his mother and taking over the world), Meg (the oldest," +
                        " and is the most unpopular girl in town) and Chris (the middle kid, he is not" +
                        " very bright but has a passion for movies). The final member of the family " +
                        "is Brian - a talking dog and much more than a pet, he keeps Stewie in check " +
                        "whilst sipping Martinis and sorting through his own life issues.",
                "Animation, Comedy",
                "68%",
                R.drawable.poster_family_guy
            )
        )

        listTvShow.add(
            Catalogue(
                3,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry " +
                        "Allen is struck by lightning and falls into a coma. Months later he awakens " +
                        "with the power of super speed, granting him the ability to move through Central " +
                        "City like an unseen guardian angel. Though initially excited by his newfound " +
                        "powers, Barry is shocked to discover he is not the only meta-human who " +
                        "was created in the wake of the accelerator explosion -- and not everyone is " +
                        "using their new powers for good. Barry partners with S.T.A.R. Labs and " +
                        "dedicates his life to protect the innocent. For now, only a few close friends " +
                        "and associates know that Barry is literally the fastest man alive, but it " +
                        "wont be long before the world learns what Barry Allen has become...The Flash.",
                "Drama, Sci-Fi & Fantasy",
                "75%",
                R.drawable.poster_flash
            )
        )

        listTvShow.add(
            Catalogue(
                4,
                " Marvels Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the " +
                        "power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "64%",
                R.drawable.poster_iron_fist
            )
        )

        listTvShow.add(
            Catalogue(
                5,
                "Naruto Shippuden",
                "Naruto Shippuuden is the continuation of the original animated TV series " +
                        "Naruto.The story revolves around an older and slightly more matured Uzumaki " +
                        "Naruto and his quest to save his friend Uchiha Sasuke from the grips of the " +
                        "snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally " +
                        "returns to his village of Konoha, and sets about putting his ambitions to " +
                        "work, though it will not be easy, as He has amassed a few (more dangerous) " +
                        "enemies, in the likes of the shinobi organization; Akatsuki.",
                "Animation, Comedy, Drama",
                "87%",
                R.drawable.poster_naruto_shipudden
            )
        )

        listTvShow.add(
            Catalogue(
                6,
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of " +
                        "special agents investigates any crime that has a shred of evidence connected " +
                        "to Navy and Marine Corps personnel, regardless of rank or position.",
                "Action & Adventure, Crime, Drama",
                "71%",
                R.drawable.poster_ncis
            )
        )

        listTvShow.add(
            Catalogue(
                7,
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family " +
                        "when she was 13 after being sent away from Krypton, must learn to embrace " +
                        "her powers after previously hiding them. The Danvers teach her to be careful" +
                        " with her powers, until she has to reveal them during an unexpected disaster, " +
                        "setting her on her journey of heroism.",
                "Action, Adventure, Drama, Science Fiction",
                "71%",
                R.drawable.poster_supergirl
            )
        )

        listTvShow.add(
            Catalogue(
                8,
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a " +
                        "mysterious and demonic supernatural force. Subsequently, their father raised " +
                        "them to be soldiers. He taught them about the paranormal evil that lives in " +
                        "the dark corners and on the back roads of America ... and he taught them " +
                        "how to kill it. Now, the Winchester brothers crisscross the country in their " +
                        "67 Chevy Impala, battling every kind of supernatural threat they encounter " +
                        "along the way.",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "81%",
                R.drawable.poster_supernatural
            )
        )

        listTvShow.add(
            Catalogue(
                9,
                "The Walking Dead",
                "heriffs deputy Rick Grimes awakens from a coma to find a post-apocalyptic " +
                        "world dominated by flesh-eating zombies. He sets out to find his family and " +
                        "encounters many other survivors along the way.",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "79%",
                R.drawable.poster_the_walking_dead
            )
        )
        return listTvShow
    }

    fun getDetailMovie(id: Int) : Catalogue = getMovie()[id]

    fun getDetailTvShow(id: Int) : Catalogue = getTvShow()[id]
}