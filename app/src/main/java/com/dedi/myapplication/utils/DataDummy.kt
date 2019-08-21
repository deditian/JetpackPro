package com.dedi.myapplication.utils

import android.os.Parcelable
import com.dedi.myapplication.data.MovieCatalogue
import kotlinx.android.parcel.Parcelize
import java.nio.file.Files.size

@Parcelize
object DataDummy : Parcelable {

    fun generateMovies(): ArrayList<MovieCatalogue> {
        val courses = ArrayList<MovieCatalogue>()

        courses.add(
            MovieCatalogue(
                "m01",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "moviesimage/poster_a_start_is_born.jpg"
            )
        )
        courses.add(
            MovieCatalogue(
                "m02",
                "Alita",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "moviesimage/poster_alita.jpg"
            )
        )
        courses.add(
            MovieCatalogue(
                "m03",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "moviesimage/poster_aquaman.jpg"
            )
        )
        courses.add(
            MovieCatalogue(
                "m04",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "moviesimage/poster_bohemian.jpg"
            )
        )
        courses.add(
            MovieCatalogue(
                "m05",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "moviesimage/poster_cold_persuit.jpg"
            )
        )
        courses.add(
            MovieCatalogue(
                "m06",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "moviesimage/poster_creed.jpg"
            )
        )
       courses.add(
            MovieCatalogue(
                "m07",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "moviesimage/poster_how_to_train.jpg"
            )
        )
       courses.add(
            MovieCatalogue(
                "m08",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "moviesimage/poster_infinity_war.jpg"
            )
        )
       courses.add(
            MovieCatalogue(
                "m09",
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi (Zhang) tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it s not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "moviesimage/poster_master_z.jpg"
            )
        )
       courses.add(
            MovieCatalogue(
                "m10",
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "moviesimage/poster_mortal_engines.jpg"
            )
        )

        return courses
    }

    fun generateTvShows(): ArrayList<MovieCatalogue> {
        val courses = ArrayList<MovieCatalogue>()

        courses.add(
            MovieCatalogue(
                "t01",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "tvshowsimage/poster_arrow.jpg"
            )
        )
        courses.add(
            MovieCatalogue(
                "t02",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "tvshowsimage/poster_doom_patrol.jpg"
            )
        )
        courses.add(
            MovieCatalogue(
                "t03",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure.",
                "tvshowsimage/poster_dragon_ball.jpg"
            )
        )
        courses.add(
            MovieCatalogue(
                "t04",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "tvshowsimage/poster_fairytail.jpg"
            )
        )
        courses.add(
            MovieCatalogue(
                "t05",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "tvshowsimage/poster_family_guy.jpg"
            )
        )
        courses.add(
            MovieCatalogue(
                "t06",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "tvshowsimage/poster_flash.jpg"
            )
        )
       courses.add(
            MovieCatalogue(
                "t07",
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "tvshowsimage/poster_gotham.jpg"
            )
        )
       courses.add(
            MovieCatalogue(
                "t08",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "tvshowsimage/poster_grey_anatomy.jpg"
            )
        )
       courses.add(
            MovieCatalogue(
                "t09",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.,",
                "tvshowsimage/poster_hanna.jpg"
            )
        )
       courses.add(
            MovieCatalogue(
                "t10",
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "tvshowsimage/poster_iron_fist.jpg"
            )
        )

        return courses
    }


}