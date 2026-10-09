package com.ielts.speaking.data.repository

import com.ielts.speaking.data.model.Band9Vocabulary

object AuthenticCambridgeArchive {
    val themes: Map<Int, SpeakingDataProvider.YearTheme> = mapOf(
        2026 to SpeakingDataProvider.YearTheme(
            year = 2026,
            cambridgeBook = "Cambridge IELTS 20",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a difficult challenge you met and ov...",
                theme = "Cambridge 20 Test 1 \u2022 Personal Resilience & Life Challenges",
                p1Topic = "Daily Routines & Time Allocation",
                p1Questions = listOf("What part of the day do you find most productive for focused tasks?", "Have your morning or evening habits changed noticeably over recent years?", "Do you utilize any digital applications to organize your daily schedule?"),
                p2Cue = "Describe a difficult challenge you met and overcame.",
                p2Bullets = listOf("What the challenge was", "When and why you faced it", "What decisive steps you took to overcome it", "And explain what profound insights you gained from this experience."),
                p3Topic = "Psychological Fortitude & Problem Solving",
                p3Questions = listOf("Why are certain individuals naturally more resilient in the face of unexpected adversity?", "Should formal school curricula place greater emphasis on coping mechanisms for failure?", "How does having a trustworthy social circle influence an individual's emotional stamina?"),
                p4Topic = "Modern Anxieties vs Traditional Hardships",
                p4Questions = listOf("Are contemporary societal challenges predominantly cognitive and emotional rather than physical?", "In what ways can civic leaders cultivate mutual support during widespread crises?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an eco-friendly habit or conservatio...",
                theme = "Cambridge 20 Test 2 \u2022 Ecological Habits & Sustainability",
                p1Topic = "Natural Spaces & Outdoor Recreation",
                p1Questions = listOf("Do you frequently visit parks, botanical gardens, or nature reserves?", "Did you spend considerable time outdoors during your early childhood?", "Are public green recreational zones sufficient in your home locality?"),
                p2Cue = "Describe an eco-friendly habit or conservation activity you practice.",
                p2Bullets = listOf("What activity or lifestyle habit it is", "When and how you first incorporated it into your routine", "What practical difficulties you faced in sustaining it", "And explain why you believe this contributes meaningfully to planetary health."),
                p3Topic = "Grassroots Activism vs Corporate Accountability",
                p3Questions = listOf("Can individual consumer frugality realistically counterbalance industrial pollution?", "Should statutory fines be levied against manufacturing companies utilizing non-biodegradable plastics?", "How can educators inspire pupils to become proactive ecological stewards?"),
                p4Topic = "Renewable Energy Transition & Global Equity",
                p4Questions = listOf("Why do emerging economies encounter unique financial obstacles in adopting clean energy?", "Are international climate accords effective without legally binding punitive mechanisms?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe an innovative transport system or sm...",
                theme = "Cambridge 20 Test 3 \u2022 Public Transportation & Urban Design",
                p1Topic = "Commuting & Transit Convenience",
                p1Questions = listOf("What mode of public transportation do you rely on most frequently?", "How reliable and convenient is public transit in your residential area?", "Do you anticipate that private vehicular travel will be restricted in capital centers?"),
                p2Cue = "Describe an innovative transport system or smart city service you used.",
                p2Bullets = listOf("What transit system or smart service you utilized", "Where and on what occasion you experienced it", "How it facilitated your journey or eliminated delays", "And explain how it enhanced the overall livability of that municipality."),
                p3Topic = "Decongesting Metropolises & Urban Mobility",
                p3Questions = listOf("What incentives are most effective in encouraging car commuters to switch to rail transit?", "What socio-economic repercussions stem from exorbitant housing costs in urban centers?", "Should metropolitan public transport networks be funded entirely by taxation and free to riders?"),
                p4Topic = "Digital Accessibility & Civic Equity",
                p4Questions = listOf("Does the rapid digitalization of municipal ticketing inadvertently exclude senior citizens?", "How can city councils ensure state-of-the-art infrastructure is equitably distributed across all districts?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a hobby or activity you do away from...",
                theme = "Cambridge 20 Test 4 \u2022 Screen Time & Modern Leisure",
                p1Topic = "Digital Habits & Screen Interactivity",
                p1Questions = listOf("How many hours do you estimate you spend staring at electronic displays each day?", "What recreational pursuits do you enjoy entirely detached from digital devices?", "Do you find it straightforward to ignore digital notifications while resting?"),
                p2Cue = "Describe a hobby or activity you do away from computer screens to maintain mental wellness.",
                p2Bullets = listOf("What the activity or hobby entails", "How frequently and where you participate in it", "Who, if anyone, joins you in this activity", "And explain how it helps you restore your mental clarity and emotional composure."),
                p3Topic = "Workplace Fatigue & Work-Life Equilibrium",
                p3Questions = listOf("Why has chronic occupational burnout reached unprecedented levels among white-collar employees?", "Should legislation grant employees the legal right to disconnect from corporate emails after hours?", "In what ways does social media curated content undermine the psychological self-worth of adolescents?"),
                p4Topic = "Mental Health Literacy in Contemporary Society",
                p4Questions = listOf("What factors have contributed to the progressive de-stigmatization of mental health counseling?", "How can higher education institutions foster proactive psychological resilience among scholars?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2025 to SpeakingDataProvider.YearTheme(
            year = 2025,
            cambridgeBook = "Cambridge IELTS 20",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe an educational software application ...",
                theme = "Cambridge 20 Test 1 \u2022 Artificial Intelligence in Education",
                p1Topic = "Cognitive Software & Digital Study Tools",
                p1Questions = listOf("Do you use digital applications to assist with memorization or writing?", "How did your teachers utilize computer technology during your secondary schooling?", "Will artificial intelligence eventually render traditional textbooks obsolete?"),
                p2Cue = "Describe an educational software application or AI tool that improved your workflow.",
                p2Bullets = listOf("What software or digital tool it was", "When and why you began utilizing it", "How it assisted your scholastic tasks", "And explain why you regard it as an indispensable academic asset."),
                p3Topic = "Pedagogy & Digital Automation",
                p3Questions = listOf("Can automated tutoring software replace the emotional empathy of a human educator?", "Should schools ban generative AI tools during formal student assessments?", "How can educational institutions ensure students develop authentic critical thinking?"),
                p4Topic = "Future Workforce Skills",
                p4Questions = listOf("What human qualities will remain irreplaceable despite advances in machine automation?", "How should universities redesign degree programs to prepare scholars for automated industries?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an eco-friendly marine initiative or...",
                theme = "Cambridge 20 Test 2 \u2022 Marine Conservation & Coastal Habitats",
                p1Topic = "Coastal Visits & Ocean Recreation",
                p1Questions = listOf("Do you enjoy spending vacations near the ocean or coastal waterways?", "What activities are popular along coastlines in your home country?", "Have you ever participated in a beach cleanup or environmental initiative?"),
                p2Cue = "Describe an eco-friendly marine initiative or conservation project you learned about.",
                p2Bullets = listOf("What the marine conservation initiative involves", "Where and how you first discovered it", "What environmental threats it aims to alleviate", "And explain why marine biodiversity preservation is paramount."),
                p3Topic = "Ocean Ecology & Microplastics",
                p3Questions = listOf("How severely does plastic waste in marine biomes jeopardize global food chains?", "Should governments levy steep environmental taxes on disposable non-recyclable containers?", "Can international agreements effectively halt overfishing in open international waters?"),
                p4Topic = "Coastal Urbanization & Sea Levels",
                p4Questions = listOf("What urban engineering strategies can shield low-lying metropolitan centers from rising tides?", "How can developing coastal nations finance climate adaptation infrastructure equitably?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable long-distance journey yo...",
                theme = "Cambridge 20 Test 3 \u2022 High-Speed Rail & Regional Connectivity",
                p1Topic = "Train Travel & Regional Journeys",
                p1Questions = listOf("Do you prefer traveling across provinces by train, bus, or private vehicle?", "Is high-speed railway infrastructure well-developed in your country?", "What features make long-distance rail journeys pleasant and relaxing?"),
                p2Cue = "Describe a memorable long-distance journey you took on a modern train.",
                p2Bullets = listOf("Where you traveled and what the purpose of the trip was", "Who accompanied you on the journey", "What landscapes or landmarks you observed along the railway", "And explain why this journey left an indelible impression upon you."),
                p3Topic = "Intercity Rail vs Domestic Aviation",
                p3Questions = listOf("Should governments subsidize bullet rail networks to discourage carbon-heavy short-haul flights?", "How do modern transit corridors foster economic prosperity in peripheral towns?", "What are the primary logistical barriers to building transcontinental rail systems?"),
                p4Topic = "Future of Public Transit",
                p4Questions = listOf("Will autonomous magnetic levitation transit replace traditional vehicular transport in major capitals?", "How can transit authorities guarantee clean, affordable public transport for low-income citizens?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a restorative lifestyle change you a...",
                theme = "Cambridge 20 Test 4 \u2022 Sleep Patterns & Mental Rest",
                p1Topic = "Sleep Habits & Night Routines",
                p1Questions = listOf("How many hours of restful sleep do you typically average each night?", "Do you adhere to a structured bedtime routine to ensure deep rest?", "Has nighttime screen interactivity impacted the sleep quality of younger generations?"),
                p2Cue = "Describe a restorative lifestyle change you adopted to enhance mental well-being.",
                p2Bullets = listOf("What habit or routine you altered", "When and why you decided to make this adjustment", "What immediate improvements you experienced", "And explain how this practice preserves your psychological fortitude."),
                p3Topic = "Circadian Rhythms & Work Schedules",
                p3Questions = listOf("Why does the modern 24/7 economy precipitate severe chronic sleep deprivation?", "Should corporate employers provide quiet spaces for power naps during demanding workdays?", "How does persistent exhaustion undermine workplace decision-making and safety?"),
                p4Topic = "Societal Wellness & Rest",
                p4Questions = listOf("Has contemporary culture glorified overwork at the expense of human health?", "What statutory measures can national governments implement to protect work-life balance?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2024 to SpeakingDataProvider.YearTheme(
            year = 2024,
            cambridgeBook = "Cambridge IELTS 19",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a law that was introduced in your co...",
                theme = "Cambridge 19 Test 1 \u2022 International Food & Legal System",
                p1Topic = "International Cuisine & Dining",
                p1Questions = listOf("Can you find food from many different countries where you live?", "How often do you eat typical food from other countries?", "Have you ever tried making food from another country?"),
                p2Cue = "Describe a law that was introduced in your country and that you thought was a very good idea.",
                p2Bullets = listOf("What the law was", "Who introduced it", "When and why it was introduced", "And explain why you thought this law was such a good idea."),
                p3Topic = "School Rules & Legal Profession",
                p3Questions = listOf("Do you think rules in schools should be very strict?", "Why do some people choose to study and practice law?", "How have public attitudes towards civic laws shifted in recent generations?"),
                p4Topic = "Law Enforcement & Societal Compliance",
                p4Questions = listOf("Is community rehabilitation more effective than custodial sentences for minor infractions?", "How can modern legal systems be made financially accessible to ordinary citizens?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe a prize or reward that you received.",
                theme = "Cambridge 19 Test 2 \u2022 Prizes, Recognition & Holidaying",
                p1Topic = "Vacations & Gift Traditions",
                p1Questions = listOf("Do you prefer relaxing vacations or active excursions?", "What kind of gifts do you find most meaningful to give?", "Have you ever received a memorable holiday souvenir?"),
                p2Cue = "Describe a prize or reward that you received.",
                p2Bullets = listOf("What the prize was", "What you had to do to earn it", "Who presented it to you", "And explain how you felt when you received it."),
                p3Topic = "Incentives, Praise & Motivation",
                p3Questions = listOf("Should primary schools award honors solely for high performance or also for effort?", "What incentives work best to inspire modern employees?", "Can monetary rewards stifle intrinsic curiosity?"),
                p4Topic = "Competitiveness in Modern Culture",
                p4Questions = listOf("Is contemporary society fostering an unhealthy fixation on winning at all costs?", "How can parents teach adolescents to perceive defeat as an instructional stepping stone?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person who always has interesting ...",
                theme = "Cambridge 19 Test 3 \u2022 Everyday Objects & Creative Thinkers",
                p1Topic = "Mirrors & Everyday Objects",
                p1Questions = listOf("How frequently do you check your appearance in a mirror?", "Do you have large decorative mirrors in your house?", "Have you ever purchased a vintage mirror?"),
                p2Cue = "Describe a person who always has interesting ideas or opinions.",
                p2Bullets = listOf("Who this person is", "What unconventional ideas they frequently share", "How peers react to their viewpoints", "And explain why you find their thinking so engaging."),
                p3Topic = "Creativity & Original Thinking",
                p3Questions = listOf("Can innovative thinking be taught, or is it an innate gift?", "How can companies cultivate an atmosphere where original ideas flourish?", "Why do traditional institutions often resist radical reforms?"),
                p4Topic = "Pedagogy & Critical Inquiry",
                p4Questions = listOf("Should academic assessment systems reward independent skepticism over standard textbook regurgitation?", "How does rigorous debate with opposing viewpoints sharpen an individual's analytical acumen?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a place you visited that had a beaut...",
                theme = "Cambridge 19 Test 4 \u2022 Landscape Aesthetics & Ecotourism",
                p1Topic = "Scenery & Panoramic Views",
                p1Questions = listOf("Do you prefer looking at a city skyline or an untouched natural vista?", "Is there an attractive view from the windows of your house?", "Why do people enjoy photographing scenic viewpoints?"),
                p2Cue = "Describe a place you visited that had a beautiful view.",
                p2Bullets = listOf("Where this place was situated", "When and why you traveled there", "What striking landmarks you observed", "And explain why this view left an indelible impression upon you."),
                p3Topic = "Tourism & Natural Landscapes",
                p3Questions = listOf("Why are scenic mountain and coastal locations so magnetic to travelers?", "How does overtourism jeopardize delicate natural biomes?", "What measures should governments take to protect pristine viewpoints?"),
                p4Topic = "Preservation of Wilderness",
                p4Questions = listOf("Should commercial hotels be banned from establishing resorts in national conservation zones?", "How can eco-tour operators balance commercial profitability with ecological integrity?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2023 to SpeakingDataProvider.YearTheme(
            year = 2023,
            cambridgeBook = "Cambridge IELTS 18",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a food or drink you learned to prepa...",
                theme = "Cambridge 18 Test 1 \u2022 Food Culture & Culinary Skills",
                p1Topic = "Cooking & Daily Food",
                p1Questions = listOf("Do you enjoy cooking meals for yourself or others?", "What kind of food did you eat when you were younger?", "Is it easy to buy fresh ingredients where you live?"),
                p2Cue = "Describe a food or drink you learned to prepare.",
                p2Bullets = listOf("What it is", "When, where, and how you learned to prepare it", "What ingredients are required", "And explain how you felt about learning it."),
                p3Topic = "Modern Diets & Traditional Cooking",
                p3Questions = listOf("Why are fast food restaurants becoming so widespread globally?", "Should cooking skills be compulsory in primary school curriculums?", "How does dining together strengthen familial cohesion?"),
                p4Topic = "Culinary Heritage",
                p4Questions = listOf("Does the globalization of restaurant franchises threaten traditional regional cooking styles?", "How can nations protect their indigenous food cultures from commercial homogenization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe a tourist attraction you recently vi...",
                theme = "Cambridge 18 Test 2 \u2022 Travel Destinations & Sightseeing",
                p1Topic = "Visiting Famous Places",
                p1Questions = listOf("Do you like visiting famous historical landmarks?", "What makes a destination popular among tourists?", "How has travel changed in recent years?"),
                p2Cue = "Describe a tourist attraction you recently visited and would recommend.",
                p2Bullets = listOf("What the attraction is", "Where it is situated", "What visitors can see and do there", "And explain why you would recommend it."),
                p3Topic = "Impact of Tourism & Heritage Sites",
                p3Questions = listOf("How can governments protect cultural monuments from weathering and crowds?", "Does international tourism foster greater cross-cultural empathy?", "Should historical museums offer free admission to the public?"),
                p4Topic = "Cultural Tourism Economics",
                p4Questions = listOf("How can regional municipalities prevent historical downtowns from turning into synthetic tourist traps?", "What policies ensure local inhabitants benefit directly from tourist revenues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a time when you enjoyed visiting a m...",
                theme = "Cambridge 18 Test 3 \u2022 Family Traditions & Home Life",
                p1Topic = "Family Gatherings & Visits",
                p1Questions = listOf("How often do you meet with extended family members?", "What activities do family generations usually enjoy together?", "Do you prefer small or large family get-togethers?"),
                p2Cue = "Describe a time when you enjoyed visiting a member of your family in their home.",
                p2Bullets = listOf("Who you visited", "Why you made the visit", "What happened during the stay", "And explain what made it so enjoyable."),
                p3Topic = "Generational Bonds & Changing Families",
                p3Questions = listOf("In what ways are modern family structures changing compared to the past?", "How can older and younger generations bridge communication gaps?", "Should working adults reside with elderly parents?"),
                p4Topic = "Elder Care & Societal Obligations",
                p4Questions = listOf("Is elder care primarily the fiscal responsibility of the state or the ethical duty of offspring?", "How can community centers keep elderly citizens active and integrated?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a time when you met someone who you ...",
                theme = "Cambridge 18 Test 4 \u2022 Friendship & Social Connections",
                p1Topic = "Making Friends & Social Networks",
                p1Questions = listOf("Do you find it easy to form new friendships?", "What qualities do you value most in a close friend?", "Is it possible to maintain friendships purely online?"),
                p2Cue = "Describe a time when you met someone who you became good friends with.",
                p2Bullets = listOf("Who this person is", "When and where you met", "What you did together", "And explain why you became good friends."),
                p3Topic = "Friendship in Adulthood & Digital Society",
                p3Questions = listOf("Why is maintaining close friendships often more difficult during adulthood?", "Do virtual social platforms enhance or erode genuine human connections?", "Can professional colleagues maintain deep personal friendships?"),
                p4Topic = "Loneliness & Urban Life",
                p4Questions = listOf("Why has profound urban isolation risen despite unprecedented digital interconnectedness?", "How can municipal town planners design social spaces that encourage spontaneous neighborly interaction?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2022 to SpeakingDataProvider.YearTheme(
            year = 2022,
            cambridgeBook = "Cambridge IELTS 17",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a delicious and healthy recipe or di...",
                theme = "Cambridge 17 Test 1 \u2022 Fast Food, Nutrition & Beverages",
                p1Topic = "Dietary Habits & Eating Out",
                p1Questions = listOf("What types of fast food are most popular in your city?", "Do you check nutritional labels when buying packaged food?", "How often do you prepare home-cooked meals?"),
                p2Cue = "Describe a delicious and healthy recipe or dish you know how to prepare.",
                p2Bullets = listOf("What dish it is", "What fresh ingredients are needed", "How it is cooked and served", "And explain why it is both nutritious and enjoyable."),
                p3Topic = "Public Health & Sugar Taxes",
                p3Questions = listOf("Should governments impose punitive sugar taxes on processed junk foods?", "How can schools cultivate balanced eating habits in young children?", "Why do unhealthy processed foods cost less than fresh organic produce?"),
                p4Topic = "Corporate Food Marketing",
                p4Questions = listOf("Should television advertising of fast foods to children be banned outright?", "Can plant-based meat substitutes realistically replace animal agriculture?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an occasion when you got lost in an ...",
                theme = "Cambridge 17 Test 2 \u2022 Daily Commutes & Urban Journeys",
                p1Topic = "Getting Around & Urban Transport",
                p1Questions = listOf("How long does your typical daily commute take?", "Do you prefer commuting by bus, subway, or private car?", "Have you ever lost your way in a large unfamiliar city?"),
                p2Cue = "Describe an occasion when you got lost in an unfamiliar city or neighborhood.",
                p2Bullets = listOf("Where you were and where you were attempting to go", "How you realized you had lost your direction", "How you asked for guidance or resolved the dilemma", "And explain what you learned from this experience."),
                p3Topic = "Urban Navigation & Digital Maps",
                p3Questions = listOf("Has widespread reliance on satellite GPS navigation eroded human orientation skills?", "How can city councils make public transit accessible for tourists who do not speak the local language?", "What factors make an urban transit system pleasurable to use?"),
                p4Topic = "Congestion Reduction",
                p4Questions = listOf("Is pedestrianizing historic city centers effective in boosting local commerce?", "Should private combustion vehicles be barred from entering downtown metropolitan zones during rush hours?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe an interesting or thought-provoking ...",
                theme = "Cambridge 17 Test 3 \u2022 Social Media & Digital Discourse",
                p1Topic = "Online Communication & Chat Apps",
                p1Questions = listOf("Which social messaging platforms do you use on a daily basis?", "Do you participate in large online discussion forums or groups?", "How do you filter out misinformation on digital social media?"),
                p2Cue = "Describe an interesting or thought-provoking discussion you had online.",
                p2Bullets = listOf("What topic or subject the discussion centered upon", "Where online the debate took place", "What compelling perspectives were shared by participants", "And explain why this exchange influenced your own viewpoint."),
                p3Topic = "Digital Echo Chambers & Polarization",
                p3Questions = listOf("Why do automated social media recommendation algorithms foster ideological echo chambers?", "Can online civil discourse ever replicate the empathy and nuance of face-to-face dialogue?", "How can citizens develop digital literacy to detect manipulated news stories?"),
                p4Topic = "Regulation of Social Networks",
                p4Questions = listOf("Should social media technology conglomerates be held legally responsible for hate speech on their servers?", "Where is the democratic balance between protecting free expression and preventing malicious defamation online?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a historic museum or art gallery tha...",
                theme = "Cambridge 17 Test 4 \u2022 Museums, Art Galleries & Artifacts",
                p1Topic = "Visiting Cultural Museums",
                p1Questions = listOf("Did you visit historical museums during school field trips?", "What types of exhibitions interest you most: science, history, or fine arts?", "Are museums in your country well-attended by the younger generation?"),
                p2Cue = "Describe a historic museum or art gallery that made a deep impression on you.",
                p2Bullets = listOf("What museum it was and where it was situated", "When you visited it and who accompanied you", "What notable historical artifacts or paintings you observed", "And explain why this museum visit proved so culturally enriching."),
                p3Topic = "Cultural Repatriation & Historical Memory",
                p3Questions = listOf("Should international museums return acquired historical artifacts to their countries of origin?", "How can modern museums incorporate virtual reality and interactive digital displays effectively?", "Why is preserving cultural heritage critical for national identity?"),
                p4Topic = "Funding Cultural Institutions",
                p4Questions = listOf("Should national cultural museums be funded entirely by taxpayer revenues and free to all visitors?", "Can private corporate sponsorships compromise the scholarly independence of artistic institutions?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2021 to SpeakingDataProvider.YearTheme(
            year = 2021,
            cambridgeBook = "Cambridge IELTS 16",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe an effective remote working or study...",
                theme = "Cambridge 16 Test 1 \u2022 Remote Work & Telecommuting",
                p1Topic = "Working from Home & Study Spaces",
                p1Questions = listOf("Do you prefer working in an office environment or studying remotely from home?", "What equipment is essential for an efficient remote workspace?", "How do you maintain self-discipline when studying independently?"),
                p2Cue = "Describe an effective remote working or study routine you established.",
                p2Bullets = listOf("What your routine involved", "How you structured your work hours and breaks", "What obstacles or distractions you had to overcome", "And explain why this routine enhanced your personal productivity."),
                p3Topic = "Future of the Workplace",
                p3Questions = listOf("Will hybrid working arrangements permanently replace traditional five-day corporate office schedules?", "How can remote companies preserve team camaraderie and corporate culture without physical presence?", "What ergonomic and mental health challenges arise from extended home telecommuting?"),
                p4Topic = "Urban Impact of Remote Labor",
                p4Questions = listOf("Does the decentralization of office work revitalize suburban towns at the expense of city business districts?", "Should employers be legally required to subsidize employees' home utility costs for remote work?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe a piece of clean energy technology o...",
                theme = "Cambridge 16 Test 2 \u2022 Renewable Energy & Solar Power",
                p1Topic = "Energy Use & Conservation",
                p1Questions = listOf("What steps do you take at home to conserve electricity?", "Are solar panels common on residential rooftops in your area?", "What clean energy sources does your country primarily utilize?"),
                p2Cue = "Describe a piece of clean energy technology or an energy-saving device you used.",
                p2Bullets = listOf("What technology or appliance it was", "How it functions to save power or harness clean energy", "Where you first saw or used it", "And explain why widespread adoption of this technology is vital."),
                p3Topic = "Decarbonization & Grid Transition",
                p3Questions = listOf("What are the primary logistical hurdles in converting national electrical grids entirely to wind and solar?", "Should governments end all fossil fuel extraction subsidies immediately?", "How can emerging developing economies transition to clean energy without hindering industrial growth?"),
                p4Topic = "Nuclear Energy Debate",
                p4Questions = listOf("Is modern small-scale nuclear power an indispensable bridge toward global carbon neutrality?", "How can regulatory bodies resolve persistent public anxieties regarding nuclear waste management?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a fascinating space discovery or ast...",
                theme = "Cambridge 16 Test 3 \u2022 Space Exploration & Astronomy",
                p1Topic = "Stargazing & Space Science",
                p1Questions = listOf("Do you enjoy looking up at the night sky and stars?", "Did you study astronomy or celestial science in school?", "Have you ever viewed celestial bodies through an astronomical telescope?"),
                p2Cue = "Describe a fascinating space discovery or astronomical article you read about.",
                p2Bullets = listOf("What space mission or celestial discovery it concerned", "Where and when you read about it", "What groundbreaking insights astronomers uncovered", "And explain why space exploration inspires humanity."),
                p3Topic = "Commercial Spaceflight & Colonization",
                p3Questions = listOf("Is public expenditure on interplanetary exploration justifiable when deep domestic social crises persist on Earth?", "Will private commercial space tourism precipitate atmospheric pollution in the stratosphere?", "What international treaties should govern the extraction of mineral resources from asteroids and the Moon?"),
                p4Topic = "Scientific Spin-offs",
                p4Questions = listOf("How have technological breakthroughs engineered for space missions directly benefited daily human life?", "Does contemplating the vastness of the cosmos foster deeper philosophical humility among humanity?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe an athletic event or sports competit...",
                theme = "Cambridge 16 Test 4 \u2022 Fitness, Athletics & Outdoor Sports",
                p1Topic = "Exercise Habits & Physical Activities",
                p1Questions = listOf("What type of exercise or physical recreation do you participate in regularly?", "Did you engage in competitive sports during your school years?", "Are public sports facilities easily accessible in your locality?"),
                p2Cue = "Describe an athletic event or sports competition that you participated in or watched.",
                p2Bullets = listOf("What sports event or tournament it was", "When and where it took place", "What exciting or memorable moments occurred during the competition", "And explain how you felt about the final outcome."),
                p3Topic = "Athletics in Society & Mental Health",
                p3Questions = listOf("How does regular aerobic exercise alleviate symptoms of clinical anxiety and occupational burnout?", "Should national sports federations allocate equal financial compensation to male and female athletes?", "Why do professional athletes struggle with severe psychological pressure under international media scrutiny?"),
                p4Topic = "Youth Physical Literacy",
                p4Questions = listOf("How can educational school systems encourage non-athletic pupils to embrace lifelong physical activity?", "Does modern sedentary screen gaming jeopardize the cardiovascular wellness of adolescents?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2020 to SpeakingDataProvider.YearTheme(
            year = 2020,
            cambridgeBook = "Cambridge IELTS 15",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 15 Test 1 \u2022 Global E-Commerce & Deliveries",
                p1Topic = "Global E-Commerce & Deliveries",
                p1Questions = listOf("Can you tell me about your experience regarding global e-commerce & deliveries?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving global e-commerce & deliveries.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Global E-Commerce & Deliveries",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 15 Test 2 \u2022 Severe Weather & Storms",
                p1Topic = "Severe Weather & Storms",
                p1Questions = listOf("Is severe weather & storms something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to severe weather & storms.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 15 Test 3 \u2022 Urban Plazas & Modern Architecture",
                p1Topic = "Urban Plazas & Modern Architecture",
                p1Questions = listOf("Did you encounter urban plazas & modern architecture during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in urban plazas & modern architecture that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 15 Test 4 \u2022 Live Concerts & Performing Arts",
                p1Topic = "Live Concerts & Performing Arts",
                p1Questions = listOf("Do you regularly allocate time for live concerts & performing arts during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in live concerts & performing arts.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2019 to SpeakingDataProvider.YearTheme(
            year = 2019,
            cambridgeBook = "Cambridge IELTS 14",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 14 Test 1 \u2022 Wildlife Sanctuaries & Faunal Conservation",
                p1Topic = "Wildlife Sanctuaries & Faunal Conservation",
                p1Questions = listOf("Can you tell me about your experience regarding wildlife sanctuaries & faunal conservation?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving wildlife sanctuaries & faunal conservation.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Wildlife Sanctuaries & Faunal Conservation",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 14 Test 2 \u2022 University Research & Scholarly Degrees",
                p1Topic = "University Research & Scholarly Degrees",
                p1Questions = listOf("Is university research & scholarly degrees something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to university research & scholarly degrees.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 14 Test 3 \u2022 Robotics & Industrial Automation",
                p1Topic = "Robotics & Industrial Automation",
                p1Questions = listOf("Did you encounter robotics & industrial automation during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in robotics & industrial automation that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 14 Test 4 \u2022 Reading Habits & Classical Literature",
                p1Topic = "Reading Habits & Classical Literature",
                p1Questions = listOf("Do you regularly allocate time for reading habits & classical literature during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in reading habits & classical literature.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2018 to SpeakingDataProvider.YearTheme(
            year = 2018,
            cambridgeBook = "Cambridge IELTS 13",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 13 Test 1 \u2022 Cultural Costumes & Folk Ceremonies",
                p1Topic = "Cultural Costumes & Folk Ceremonies",
                p1Questions = listOf("Can you tell me about your experience regarding cultural costumes & folk ceremonies?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving cultural costumes & folk ceremonies.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Cultural Costumes & Folk Ceremonies",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 13 Test 2 \u2022 Freshwater Rivers & Lake Ecosystems",
                p1Topic = "Freshwater Rivers & Lake Ecosystems",
                p1Questions = listOf("Is freshwater rivers & lake ecosystems something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to freshwater rivers & lake ecosystems.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 13 Test 3 \u2022 Public Libraries & Community Knowledge",
                p1Topic = "Public Libraries & Community Knowledge",
                p1Questions = listOf("Did you encounter public libraries & community knowledge during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in public libraries & community knowledge that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 13 Test 4 \u2022 Youth Mentorship & Civic Volunteering",
                p1Topic = "Youth Mentorship & Civic Volunteering",
                p1Questions = listOf("Do you regularly allocate time for youth mentorship & civic volunteering during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in youth mentorship & civic volunteering.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2017 to SpeakingDataProvider.YearTheme(
            year = 2017,
            cambridgeBook = "Cambridge IELTS 12",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 12 Test 1 \u2022 Commercial Aviation & Flight Journeys",
                p1Topic = "Commercial Aviation & Flight Journeys",
                p1Questions = listOf("Can you tell me about your experience regarding commercial aviation & flight journeys?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving commercial aviation & flight journeys.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Commercial Aviation & Flight Journeys",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 12 Test 2 \u2022 Organic Horticulture & Farmers' Markets",
                p1Topic = "Organic Horticulture & Farmers' Markets",
                p1Questions = listOf("Is organic horticulture & farmers' markets something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to organic horticulture & farmers' markets.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 12 Test 3 \u2022 Cinema, Movie Genres & Directing",
                p1Topic = "Cinema, Movie Genres & Directing",
                p1Questions = listOf("Did you encounter cinema, movie genres & directing during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in cinema, movie genres & directing that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 12 Test 4 \u2022 Civic Responsibility & Town Councils",
                p1Topic = "Civic Responsibility & Town Councils",
                p1Questions = listOf("Do you regularly allocate time for civic responsibility & town councils during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in civic responsibility & town councils.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2016 to SpeakingDataProvider.YearTheme(
            year = 2016,
            cambridgeBook = "Cambridge IELTS 11",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 11 Test 1 \u2022 Language Acquisition & Multilingualism",
                p1Topic = "Language Acquisition & Multilingualism",
                p1Questions = listOf("Can you tell me about your experience regarding language acquisition & multilingualism?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving language acquisition & multilingualism.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Language Acquisition & Multilingualism",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 11 Test 2 \u2022 Solid Waste Reduction & Packaging",
                p1Topic = "Solid Waste Reduction & Packaging",
                p1Questions = listOf("Is solid waste reduction & packaging something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to solid waste reduction & packaging.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 11 Test 3 \u2022 Botanical Green Belts & Tree Planting",
                p1Topic = "Botanical Green Belts & Tree Planting",
                p1Questions = listOf("Did you encounter botanical green belts & tree planting during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in botanical green belts & tree planting that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 11 Test 4 \u2022 Artistic Photography & Visual Memory",
                p1Topic = "Artistic Photography & Visual Memory",
                p1Questions = listOf("Do you regularly allocate time for artistic photography & visual memory during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in artistic photography & visual memory.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2015 to SpeakingDataProvider.YearTheme(
            year = 2015,
            cambridgeBook = "Cambridge IELTS 10",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 10 Test 1 \u2022 Travel Mementos & Cultural Souvenirs",
                p1Topic = "Travel Mementos & Cultural Souvenirs",
                p1Questions = listOf("Can you tell me about your experience regarding travel mementos & cultural souvenirs?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving travel mementos & cultural souvenirs.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Travel Mementos & Cultural Souvenirs",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 10 Test 2 \u2022 Ocean Coral Reefs & Marine Life",
                p1Topic = "Ocean Coral Reefs & Marine Life",
                p1Questions = listOf("Is ocean coral reefs & marine life something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to ocean coral reefs & marine life.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 10 Test 3 \u2022 Investigative Journalism & News Ethics",
                p1Topic = "Investigative Journalism & News Ethics",
                p1Questions = listOf("Did you encounter investigative journalism & news ethics during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in investigative journalism & news ethics that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 10 Test 4 \u2022 Traditional Handcrafts & Woodwork",
                p1Topic = "Traditional Handcrafts & Woodwork",
                p1Questions = listOf("Do you regularly allocate time for traditional handcrafts & woodwork during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in traditional handcrafts & woodwork.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2014 to SpeakingDataProvider.YearTheme(
            year = 2014,
            cambridgeBook = "Cambridge IELTS 9",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 9 Test 1 \u2022 Broadcast Documentaries & Television",
                p1Topic = "Broadcast Documentaries & Television",
                p1Questions = listOf("Can you tell me about your experience regarding broadcast documentaries & television?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving broadcast documentaries & television.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Broadcast Documentaries & Television",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 9 Test 2 \u2022 Forestry Conservation & Hiking Trails",
                p1Topic = "Forestry Conservation & Hiking Trails",
                p1Questions = listOf("Is forestry conservation & hiking trails something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to forestry conservation & hiking trails.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 9 Test 3 \u2022 National Holidays & Civic Parades",
                p1Topic = "National Holidays & Civic Parades",
                p1Questions = listOf("Did you encounter national holidays & civic parades during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in national holidays & civic parades that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 9 Test 4 \u2022 Childhood Companions & Memory",
                p1Topic = "Childhood Companions & Memory",
                p1Questions = listOf("Do you regularly allocate time for childhood companions & memory during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in childhood companions & memory.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2013 to SpeakingDataProvider.YearTheme(
            year = 2013,
            cambridgeBook = "Cambridge IELTS 9",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 9 Test 1 \u2022 Handwritten Letters vs Instant Texting",
                p1Topic = "Handwritten Letters vs Instant Texting",
                p1Questions = listOf("Can you tell me about your experience regarding handwritten letters vs instant texting?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving handwritten letters vs instant texting.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Handwritten Letters vs Instant Texting",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 9 Test 2 \u2022 Acoustic Comfort & Noise Pollution",
                p1Topic = "Acoustic Comfort & Noise Pollution",
                p1Questions = listOf("Is acoustic comfort & noise pollution something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to acoustic comfort & noise pollution.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 9 Test 3 \u2022 Classical Orchestras & Instruments",
                p1Topic = "Classical Orchestras & Instruments",
                p1Questions = listOf("Did you encounter classical orchestras & instruments during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in classical orchestras & instruments that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 9 Test 4 \u2022 Career Aspirations & Leadership",
                p1Topic = "Career Aspirations & Leadership",
                p1Questions = listOf("Do you regularly allocate time for career aspirations & leadership during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in career aspirations & leadership.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2012 to SpeakingDataProvider.YearTheme(
            year = 2012,
            cambridgeBook = "Cambridge IELTS 8",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 8 Test 1 \u2022 Personal Attire & Clothing Choices",
                p1Topic = "Personal Attire & Clothing Choices",
                p1Questions = listOf("Can you tell me about your experience regarding personal attire & clothing choices?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving personal attire & clothing choices.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Personal Attire & Clothing Choices",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 8 Test 2 \u2022 Clean Drinking Water & Reservoirs",
                p1Topic = "Clean Drinking Water & Reservoirs",
                p1Questions = listOf("Is clean drinking water & reservoirs something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to clean drinking water & reservoirs.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 8 Test 3 \u2022 Primary School Instructors & STEM",
                p1Topic = "Primary School Instructors & STEM",
                p1Questions = listOf("Did you encounter primary school instructors & stem during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in primary school instructors & stem that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 8 Test 4 \u2022 Team Sports & Physical Cooperation",
                p1Topic = "Team Sports & Physical Cooperation",
                p1Questions = listOf("Do you regularly allocate time for team sports & physical cooperation during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in team sports & physical cooperation.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2011 to SpeakingDataProvider.YearTheme(
            year = 2011,
            cambridgeBook = "Cambridge IELTS 8",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 8 Test 1 \u2022 Cycling Infrastructure & City Bicycles",
                p1Topic = "Cycling Infrastructure & City Bicycles",
                p1Questions = listOf("Can you tell me about your experience regarding cycling infrastructure & city bicycles?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving cycling infrastructure & city bicycles.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Cycling Infrastructure & City Bicycles",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 8 Test 2 \u2022 Endangered Species & Habitat Preservation",
                p1Topic = "Endangered Species & Habitat Preservation",
                p1Questions = listOf("Is endangered species & habitat preservation something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to endangered species & habitat preservation.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 8 Test 3 \u2022 Billboards & Persuasive Advertising",
                p1Topic = "Billboards & Persuasive Advertising",
                p1Questions = listOf("Did you encounter billboards & persuasive advertising during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in billboards & persuasive advertising that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 8 Test 4 \u2022 Family Anniversaries & Celebration Feasts",
                p1Topic = "Family Anniversaries & Celebration Feasts",
                p1Questions = listOf("Do you regularly allocate time for family anniversaries & celebration feasts during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in family anniversaries & celebration feasts.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2010 to SpeakingDataProvider.YearTheme(
            year = 2010,
            cambridgeBook = "Cambridge IELTS 7",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 7 Test 1 \u2022 Domestic Animals & Pet Responsibility",
                p1Topic = "Domestic Animals & Pet Responsibility",
                p1Questions = listOf("Can you tell me about your experience regarding domestic animals & pet responsibility?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving domestic animals & pet responsibility.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Domestic Animals & Pet Responsibility",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 7 Test 2 \u2022 Wind Energy & Alternative Generation",
                p1Topic = "Wind Energy & Alternative Generation",
                p1Questions = listOf("Is wind energy & alternative generation something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to wind energy & alternative generation.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 7 Test 3 \u2022 Student Dormitories & Campus Life",
                p1Topic = "Student Dormitories & Campus Life",
                p1Questions = listOf("Did you encounter student dormitories & campus life during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in student dormitories & campus life that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 7 Test 4 \u2022 Sculptures, Monuments & Public Statues",
                p1Topic = "Sculptures, Monuments & Public Statues",
                p1Questions = listOf("Do you regularly allocate time for sculptures, monuments & public statues during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in sculptures, monuments & public statues.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2009 to SpeakingDataProvider.YearTheme(
            year = 2009,
            cambridgeBook = "Cambridge IELTS 7",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 7 Test 1 \u2022 Supermarket Shopping & Street Markets",
                p1Topic = "Supermarket Shopping & Street Markets",
                p1Questions = listOf("Can you tell me about your experience regarding supermarket shopping & street markets?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving supermarket shopping & street markets.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Supermarket Shopping & Street Markets",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 7 Test 2 \u2022 National Nature Reserves & Wild Flora",
                p1Topic = "National Nature Reserves & Wild Flora",
                p1Questions = listOf("Is national nature reserves & wild flora something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to national nature reserves & wild flora.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 7 Test 3 \u2022 Mobile Phone Manners in Public Spaces",
                p1Topic = "Mobile Phone Manners in Public Spaces",
                p1Questions = listOf("Did you encounter mobile phone manners in public spaces during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in mobile phone manners in public spaces that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 7 Test 4 \u2022 Wilderness Camping & Outdoor Tents",
                p1Topic = "Wilderness Camping & Outdoor Tents",
                p1Questions = listOf("Do you regularly allocate time for wilderness camping & outdoor tents during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in wilderness camping & outdoor tents.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2008 to SpeakingDataProvider.YearTheme(
            year = 2008,
            cambridgeBook = "Cambridge IELTS 6",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 6 Test 1 \u2022 Historic Streets & Old Quarters",
                p1Topic = "Historic Streets & Old Quarters",
                p1Questions = listOf("Can you tell me about your experience regarding historic streets & old quarters?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving historic streets & old quarters.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Historic Streets & Old Quarters",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 6 Test 2 \u2022 Industrial Smog & Atmospheric Emissions",
                p1Topic = "Industrial Smog & Atmospheric Emissions",
                p1Questions = listOf("Is industrial smog & atmospheric emissions something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to industrial smog & atmospheric emissions.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 6 Test 3 \u2022 Historical Milestones & Ancient Eras",
                p1Topic = "Historical Milestones & Ancient Eras",
                p1Questions = listOf("Did you encounter historical milestones & ancient eras during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in historical milestones & ancient eras that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 6 Test 4 \u2022 Personal Savings & Budget Discipline",
                p1Topic = "Personal Savings & Budget Discipline",
                p1Questions = listOf("Do you regularly allocate time for personal savings & budget discipline during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in personal savings & budget discipline.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2007 to SpeakingDataProvider.YearTheme(
            year = 2007,
            cambridgeBook = "Cambridge IELTS 6",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 6 Test 1 \u2022 Morning Habits & Healthy Breakfasts",
                p1Topic = "Morning Habits & Healthy Breakfasts",
                p1Questions = listOf("Can you tell me about your experience regarding morning habits & healthy breakfasts?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving morning habits & healthy breakfasts.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Morning Habits & Healthy Breakfasts",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 6 Test 2 \u2022 Wetland Restoration & River Streams",
                p1Topic = "Wetland Restoration & River Streams",
                p1Questions = listOf("Is wetland restoration & river streams something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to wetland restoration & river streams.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 6 Test 3 \u2022 Classroom Computers & Early Education",
                p1Topic = "Classroom Computers & Early Education",
                p1Questions = listOf("Did you encounter classroom computers & early education during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in classroom computers & early education that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 6 Test 4 \u2022 Philanthropy & Community Donations",
                p1Topic = "Philanthropy & Community Donations",
                p1Questions = listOf("Do you regularly allocate time for philanthropy & community donations during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in philanthropy & community donations.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2006 to SpeakingDataProvider.YearTheme(
            year = 2006,
            cambridgeBook = "Cambridge IELTS 5",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 5 Test 1 \u2022 Community Neighbors & Social Cohesion",
                p1Topic = "Community Neighbors & Social Cohesion",
                p1Questions = listOf("Can you tell me about your experience regarding community neighbors & social cohesion?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving community neighbors & social cohesion.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Community Neighbors & Social Cohesion",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 5 Test 2 \u2022 Fossil Fuel Consumption & Depletion",
                p1Topic = "Fossil Fuel Consumption & Depletion",
                p1Questions = listOf("Is fossil fuel consumption & depletion something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to fossil fuel consumption & depletion.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 5 Test 3 \u2022 Printed Newspapers & Investigative Articles",
                p1Topic = "Printed Newspapers & Investigative Articles",
                p1Questions = listOf("Did you encounter printed newspapers & investigative articles during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in printed newspapers & investigative articles that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 5 Test 4 \u2022 Gymnasiums, Physical Fitness & Health",
                p1Topic = "Gymnasiums, Physical Fitness & Health",
                p1Questions = listOf("Do you regularly allocate time for gymnasiums, physical fitness & health during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in gymnasiums, physical fitness & health.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2005 to SpeakingDataProvider.YearTheme(
            year = 2005,
            cambridgeBook = "Cambridge IELTS 5",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 5 Test 1 \u2022 Childhood Games & Outdoor Activities",
                p1Topic = "Childhood Games & Outdoor Activities",
                p1Questions = listOf("Can you tell me about your experience regarding childhood games & outdoor activities?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving childhood games & outdoor activities.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Childhood Games & Outdoor Activities",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 5 Test 2 \u2022 Balcony Gardens & Potted Plants",
                p1Topic = "Balcony Gardens & Potted Plants",
                p1Questions = listOf("Is balcony gardens & potted plants something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to balcony gardens & potted plants.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 5 Test 3 \u2022 Radio Broadcasting & Audio Narration",
                p1Topic = "Radio Broadcasting & Audio Narration",
                p1Questions = listOf("Did you encounter radio broadcasting & audio narration during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in radio broadcasting & audio narration that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 5 Test 4 \u2022 Adult Education & Lifelong Learning",
                p1Topic = "Adult Education & Lifelong Learning",
                p1Questions = listOf("Do you regularly allocate time for adult education & lifelong learning during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in adult education & lifelong learning.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2004 to SpeakingDataProvider.YearTheme(
            year = 2004,
            cambridgeBook = "Cambridge IELTS 4",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 4 Test 1 \u2022 Urban Pedestrian Walkways & Walkability",
                p1Topic = "Urban Pedestrian Walkways & Walkability",
                p1Questions = listOf("Can you tell me about your experience regarding urban pedestrian walkways & walkability?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving urban pedestrian walkways & walkability.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Urban Pedestrian Walkways & Walkability",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 4 Test 2 \u2022 Arid Climates & Desert Drought Management",
                p1Topic = "Arid Climates & Desert Drought Management",
                p1Questions = listOf("Is arid climates & desert drought management something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to arid climates & desert drought management.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 4 Test 3 \u2022 Science Exhibitions & Interactive Laboratories",
                p1Topic = "Science Exhibitions & Interactive Laboratories",
                p1Questions = listOf("Did you encounter science exhibitions & interactive laboratories during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in science exhibitions & interactive laboratories that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 4 Test 4 \u2022 Homemade Pastries & Culinary Baking",
                p1Topic = "Homemade Pastries & Culinary Baking",
                p1Questions = listOf("Do you regularly allocate time for homemade pastries & culinary baking during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in homemade pastries & culinary baking.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2003 to SpeakingDataProvider.YearTheme(
            year = 2003,
            cambridgeBook = "Cambridge IELTS 4",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 4 Test 1 \u2022 Seasonal Weather Changes & Preferences",
                p1Topic = "Seasonal Weather Changes & Preferences",
                p1Questions = listOf("Can you tell me about your experience regarding seasonal weather changes & preferences?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving seasonal weather changes & preferences.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Seasonal Weather Changes & Preferences",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 4 Test 2 \u2022 Timber Harvesting & Sustainable Afforestation",
                p1Topic = "Timber Harvesting & Sustainable Afforestation",
                p1Questions = listOf("Is timber harvesting & sustainable afforestation something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to timber harvesting & sustainable afforestation.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 4 Test 3 \u2022 Foreign Language Learning in High School",
                p1Topic = "Foreign Language Learning in High School",
                p1Questions = listOf("Did you encounter foreign language learning in high school during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in foreign language learning in high school that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 4 Test 4 \u2022 Oil Paintings, Portraits & Galleries",
                p1Topic = "Oil Paintings, Portraits & Galleries",
                p1Questions = listOf("Do you regularly allocate time for oil paintings, portraits & galleries during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in oil paintings, portraits & galleries.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2002 to SpeakingDataProvider.YearTheme(
            year = 2002,
            cambridgeBook = "Cambridge IELTS 3",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 3 Test 1 \u2022 Ancient Fortresses & Stone Castles",
                p1Topic = "Ancient Fortresses & Stone Castles",
                p1Questions = listOf("Can you tell me about your experience regarding ancient fortresses & stone castles?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving ancient fortresses & stone castles.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Ancient Fortresses & Stone Castles",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 3 Test 2 \u2022 Island Geography & Maritime Ferry Journeys",
                p1Topic = "Island Geography & Maritime Ferry Journeys",
                p1Questions = listOf("Is island geography & maritime ferry journeys something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to island geography & maritime ferry journeys.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 3 Test 3 \u2022 Acoustic Guitars & Folk Song Traditions",
                p1Topic = "Acoustic Guitars & Folk Song Traditions",
                p1Questions = listOf("Did you encounter acoustic guitars & folk song traditions during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in acoustic guitars & folk song traditions that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 3 Test 4 \u2022 Oral Family History & Grandparents' Lore",
                p1Topic = "Oral Family History & Grandparents' Lore",
                p1Questions = listOf("Do you regularly allocate time for oral family history & grandparents' lore during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in oral family history & grandparents' lore.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        ),
        2001 to SpeakingDataProvider.YearTheme(
            year = 2001,
            cambridgeBook = "Cambridge IELTS 2",
            set1 = SpeakingDataProvider.SetInfo(
                title = "Describe a memorable experience or milestone ...",
                theme = "Cambridge 2 Test 1 \u2022 Handwritten Postal Letters & Calligraphy",
                p1Topic = "Handwritten Postal Letters & Calligraphy",
                p1Questions = listOf("Can you tell me about your experience regarding handwritten postal letters & calligraphy?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?"),
                p2Cue = "Describe a memorable experience or milestone involving handwritten postal letters & calligraphy.",
                p2Bullets = listOf("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective."),
                p3Topic = "Analytical Perspectives on Handwritten Postal Letters & Calligraphy",
                p3Questions = listOf("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?"),
                p4Topic = "Future Trends & Long-Term Ramifications",
                p4Questions = listOf("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set2 = SpeakingDataProvider.SetInfo(
                title = "Describe an important initiative or event rel...",
                theme = "Cambridge 2 Test 2 \u2022 Organic Agricultural Harvests & Produce",
                p1Topic = "Organic Agricultural Harvests & Produce",
                p1Questions = listOf("Is organic agricultural harvests & produce something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?"),
                p2Cue = "Describe an important initiative or event related to organic agricultural harvests & produce.",
                p2Bullets = listOf("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare."),
                p3Topic = "Systemic Challenges & Public Policy",
                p3Questions = listOf("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?"),
                p4Topic = "Global Perspectives & Environmental Equilibrium",
                p4Questions = listOf("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set3 = SpeakingDataProvider.SetInfo(
                title = "Describe a person, project, or development in...",
                theme = "Cambridge 2 Test 3 \u2022 Vintage Antiques, Clocks & Family Heirlooms",
                p1Topic = "Vintage Antiques, Clocks & Family Heirlooms",
                p1Questions = listOf("Did you encounter vintage antiques, clocks & family heirlooms during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?"),
                p2Cue = "Describe a person, project, or development in vintage antiques, clocks & family heirlooms that inspired you.",
                p2Bullets = listOf("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity."),
                p3Topic = "Innovation, Pedagogy & Critical Inquiry",
                p3Questions = listOf("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?"),
                p4Topic = "Ethics & Modern Technology",
                p4Questions = listOf("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            ),
            set4 = SpeakingDataProvider.SetInfo(
                title = "Describe a rewarding activity or accomplishme...",
                theme = "Cambridge 2 Test 4 \u2022 Celestial Stargazing & Planetary Observatories",
                p1Topic = "Celestial Stargazing & Planetary Observatories",
                p1Questions = listOf("Do you regularly allocate time for celestial stargazing & planetary observatories during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?"),
                p2Cue = "Describe a rewarding activity or accomplishment in celestial stargazing & planetary observatories.",
                p2Bullets = listOf("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction."),
                p3Topic = "Societal Well-being & Cultural Value",
                p3Questions = listOf("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?"),
                p4Topic = "Future Longevity & Work-Life Equilibrium",
                p4Questions = listOf("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?"),
                keyVocab = listOf(
                    Band9Vocabulary("Indispensable dimension", "C2 Collocation", "Crucial element", "Maintaining focus is an indispensable dimension of success."),
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous grit", "Overcoming hurdles demands unwavering perseverance."),
                    Band9Vocabulary("Macroscopic stability", "Formal Lexis", "Broad societal balance", "Sound regulation fosters macroscopic stability."),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep consequences", "Unchecked policies carry far-reaching ramifications.")
                )
            )
        )
    )
}
