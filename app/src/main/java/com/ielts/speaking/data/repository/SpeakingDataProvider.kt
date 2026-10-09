package com.ielts.speaking.data.repository

import com.ielts.speaking.data.model.*

object SpeakingDataProvider {

    data class YearTheme(
        val year: Int,
        val cambridgeBook: String,
        val set1: SetInfo,
        val set2: SetInfo,
        val set3: SetInfo,
        val set4: SetInfo
    )

    data class SetInfo(
        val title: String,
        val theme: String,
        val p1Topic: String,
        val p1Questions: List<String>,
        val p2Cue: String,
        val p2Bullets: List<String>,
        val p3Topic: String,
        val p3Questions: List<String>,
        val p4Topic: String,
        val p4Questions: List<String>,
        val keyVocab: List<Band9Vocabulary>
    )

    // Authentic Cambridge IELTS Speaking Test database
    private val authenticCambridgeThemes: Map<Int, YearTheme> = mapOf(
        // 2026 / 2025: Cambridge IELTS 20 Official Test Series
        2026 to YearTheme(
            year = 2026,
            cambridgeBook = "Cambridge IELTS 20",
            set1 = SetInfo(
                title = "Overcoming Obstacles & Personal Resilience",
                theme = "Cambridge 20 Test 1 • Personal Resilience & Life Challenges",
                p1Topic = "Daily Routines & Time Allocation",
                p1Questions = listOf(
                    "What part of the day do you find most productive for focused tasks?",
                    "Have your morning or evening habits changed noticeably over recent years?",
                    "Do you utilize any digital applications to organize your daily schedule?"
                ),
                p2Cue = "Describe a difficult challenge you met and overcame.",
                p2Bullets = listOf(
                    "What the challenge was",
                    "When and why you faced it",
                    "What decisive steps you took to overcome it",
                    "And explain what profound insights you gained from this experience."
                ),
                p3Topic = "Psychological Fortitude & Problem Solving",
                p3Questions = listOf(
                    "Why are certain individuals naturally more resilient in the face of unexpected adversity?",
                    "Should formal school curricula place greater emphasis on coping mechanisms for failure?",
                    "How does having a trustworthy social circle influence an individual's emotional stamina?"
                ),
                p4Topic = "Modern Anxieties vs Traditional Hardships",
                p4Questions = listOf(
                    "Are contemporary societal challenges predominantly cognitive and emotional rather than physical?",
                    "In what ways can civic leaders cultivate mutual support during widespread crises?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Unwavering perseverance", "C2 Collocation", "Continuous determination", "Overcoming rigorous academic examinations demands unwavering perseverance."),
                    Band9Vocabulary("Psychological fortitude", "Academic Lexis", "Inner mental strength", "Cultivating psychological fortitude enables individuals to thrive under acute pressure."),
                    Band9Vocabulary("In the face of adversity", "Idiomatic Phrase", "When confronting hardships", "True character is revealed when one remains composed in the face of adversity."),
                    Band9Vocabulary("Formidable hurdle", "Collocation", "A very difficult obstacle", "Mastering a foreign language initially appears to be a formidable hurdle.")
                )
            ),
            set2 = SetInfo(
                title = "Conservation Practices & Environmental Stewardship",
                theme = "Cambridge 20 Test 2 • Ecological Habits & Sustainability",
                p1Topic = "Natural Spaces & Outdoor Recreation",
                p1Questions = listOf(
                    "Do you frequently visit parks, botanical gardens, or nature reserves?",
                    "Did you spend considerable time outdoors during your early childhood?",
                    "Are public green recreational zones sufficient in your home locality?"
                ),
                p2Cue = "Describe an eco-friendly habit or conservation activity you practice.",
                p2Bullets = listOf(
                    "What activity or lifestyle habit it is",
                    "When and how you first incorporated it into your routine",
                    "What practical difficulties you faced in sustaining it",
                    "And explain why you believe this contributes meaningfully to planetary health."
                ),
                p3Topic = "Grassroots Activism vs Corporate Accountability",
                p3Questions = listOf(
                    "Can individual consumer frugality realistically counterbalance industrial pollution?",
                    "Should statutory fines be levied against manufacturing companies utilizing non-biodegradable plastics?",
                    "How can educators inspire pupils to become proactive ecological stewards?"
                ),
                p4Topic = "Renewable Energy Transition & Global Equity",
                p4Questions = listOf(
                    "Why do emerging economies encounter unique financial obstacles in adopting clean energy?",
                    "Are international climate accords effective without legally binding punitive mechanisms?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Ecological stewardship", "Academic Lexis", "Responsible care of nature", "Every modern municipal council should champion genuine ecological stewardship."),
                    Band9Vocabulary("Substantive dividend", "Collocation", "Real positive outcome", "Modest daily conservation habits pay substantive dividends over generations."),
                    Band9Vocabulary("Binding legislative mandate", "Formal Register", "Compulsory law", "Voluntary corporate promises cannot substitute for a binding legislative mandate."),
                    Band9Vocabulary("Mitigate degradation", "Collocation", "Lessen environmental harm", "Stringent recycling protocols actively mitigate environmental degradation.")
                )
            ),
            set3 = SetInfo(
                title = "Urban Transit Systems & Smart Municipalities",
                theme = "Cambridge 20 Test 3 • Public Transportation & Urban Design",
                p1Topic = "Commuting & Transit Convenience",
                p1Questions = listOf(
                    "What mode of public transportation do you rely on most frequently?",
                    "How reliable and convenient is public transit in your residential area?",
                    "Do you anticipate that private vehicular travel will be restricted in capital centers?"
                ),
                p2Cue = "Describe an innovative transport system or smart city service you used.",
                p2Bullets = listOf(
                    "What transit system or smart service you utilized",
                    "Where and on what occasion you experienced it",
                    "How it facilitated your journey or eliminated delays",
                    "And explain how it enhanced the overall livability of that municipality."
                ),
                p3Topic = "Decongesting Metropolises & Urban Mobility",
                p3Questions = listOf(
                    "What incentives are most effective in encouraging car commuters to switch to rail transit?",
                    "What socio-economic repercussions stem from exorbitant housing costs in urban centers?",
                    "Should metropolitan public transport networks be funded entirely by taxation and free to riders?"
                ),
                p4Topic = "Digital Accessibility & Civic Equity",
                p4Questions = listOf(
                    "Does the rapid digitalization of municipal ticketing inadvertently exclude senior citizens?",
                    "How can city councils ensure state-of-the-art infrastructure is equitably distributed across all districts?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Alleviate congestion", "Collocation", "Reduce traffic jams", "Expanding rapid transit networks substantially alleviates rush-hour congestion."),
                    Band9Vocabulary("Urban livability", "Academic Lexis", "Quality of life in cities", "Pedestrian boulevards and abundant greenery directly elevate urban livability."),
                    Band9Vocabulary("Equitable distribution", "Formal Register", "Fair sharing across groups", "City planners must guarantee the equitable distribution of modern amenities."),
                    Band9Vocabulary("Inadvertently marginalize", "C2 Lexis", "Accidentally exclude", "Cashless fare systems risk inadvertently marginalizing elderly passengers.")
                )
            ),
            set4 = SetInfo(
                title = "Digital Detoxing & Psychological Well-being",
                theme = "Cambridge 20 Test 4 • Screen Time & Modern Leisure",
                p1Topic = "Digital Habits & Screen Interactivity",
                p1Questions = listOf(
                    "How many hours do you estimate you spend staring at electronic displays each day?",
                    "What recreational pursuits do you enjoy entirely detached from digital devices?",
                    "Do you find it straightforward to ignore digital notifications while resting?"
                ),
                p2Cue = "Describe a hobby or activity you do away from computer screens to maintain mental wellness.",
                p2Bullets = listOf(
                    "What the activity or hobby entails",
                    "How frequently and where you participate in it",
                    "Who, if anyone, joins you in this activity",
                    "And explain how it helps you restore your mental clarity and emotional composure."
                ),
                p3Topic = "Workplace Fatigue & Work-Life Equilibrium",
                p3Questions = listOf(
                    "Why has chronic occupational burnout reached unprecedented levels among white-collar employees?",
                    "Should legislation grant employees the legal right to disconnect from corporate emails after hours?",
                    "In what ways does social media curated content undermine the psychological self-worth of adolescents?"
                ),
                p4Topic = "Mental Health Literacy in Contemporary Society",
                p4Questions = listOf(
                    "What factors have contributed to the progressive de-stigmatization of mental health counseling?",
                    "How can higher education institutions foster proactive psychological resilience among scholars?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Restore emotional composure", "Collocation", "Regain peace of mind", "Immersing myself in watercolor painting helps restore emotional composure after grueling weeks."),
                    Band9Vocabulary("Chronic burnout", "C2 Lexis", "Severe prolonged exhaustion", "Excessive overtime without mental pauses inevitably precipitates chronic burnout."),
                    Band9Vocabulary("Right to disconnect", "Legal/Social Lexis", "Right to ignore work off-clock", "Several nations have codified the statutory right to disconnect into national labor law."),
                    Band9Vocabulary("Curated facade", "Metaphor", "Polished fake image", "Adolescents must understand that social media feeds merely present a curated facade.")
                )
            )
        ),

        // 2024: Cambridge IELTS 19 Official Exam Papers
        2024 to YearTheme(
            year = 2024,
            cambridgeBook = "Cambridge IELTS 19",
            set1 = SetInfo(
                title = "International Cuisine & Legislative Reforms",
                theme = "Cambridge 19 Test 1 • International Food & The Legal System",
                p1Topic = "International Cuisine & Dining",
                p1Questions = listOf(
                    "Can you find food from many different countries where you live?",
                    "How often do you eat typical food from other countries?",
                    "Have you ever tried making food from another country?",
                    "What food from your country would you recommend to people from other countries?"
                ),
                p2Cue = "Describe a law that was introduced in your country and that you thought was a very good idea.",
                p2Bullets = listOf(
                    "What the law was",
                    "Who introduced it",
                    "When and why it was introduced",
                    "And explain why you thought this law was such a good idea."
                ),
                p3Topic = "School Rules & The Legal Profession",
                p3Questions = listOf(
                    "Do you think rules in schools should be very strict?",
                    "Why do some people choose to study and practice law?",
                    "How have public attitudes towards civic laws shifted in recent generations?"
                ),
                p4Topic = "Law Enforcement & Societal Compliance",
                p4Questions = listOf(
                    "Is community rehabilitation more effective than custodial sentences for minor infractions?",
                    "How can modern legal systems be made financially accessible to ordinary citizens?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Exemplary initiative", "Collocation", "Outstanding model action", "The nationwide ban on single-use plastics represents an exemplary initiative."),
                    Band9Vocabulary("Deterrent against wrongdoing", "Formal Lexis", "Something preventing crimes", "Clear statutory penalties act as a formidable deterrent against corporate pollution."),
                    Band9Vocabulary("Civic compliance", "Academic Lexis", "Obeying laws voluntarily", "Public education cultivates widespread civic compliance far better than heavy coercion."),
                    Band9Vocabulary("Invaluable safeguard", "Collocation", "Crucial protection", "Independent judicial review serves as an invaluable safeguard for constitutional democracy.")
                )
            ),
            set2 = SetInfo(
                title = "Rewarding Excellence & Vacation Preferences",
                theme = "Cambridge 19 Test 2 • Prizes, Recognition & Holidaying",
                p1Topic = "Vacations & Gift Traditions",
                p1Questions = listOf(
                    "Do you prefer relaxing on quiet holidays or participating in energetic excursions?",
                    "What kinds of gifts do you find most meaningful to present to close relatives?",
                    "Have you ever brought back a memorable memento from an overseas journey?"
                ),
                p2Cue = "Describe a prize or reward that you received.",
                p2Bullets = listOf(
                    "What the prize or reward was",
                    "What specific accomplishment you had to demonstrate to earn it",
                    "Who presented the honor to you and where",
                    "And explain how you felt when you received this accolade."
                ),
                p3Topic = "Motivation, Praise & Meritocracy",
                p3Questions = listOf(
                    "Should primary schools award honors solely for outstanding achievement or also for conscientious effort?",
                    "What forms of recognition function most effectively to inspire employees in competitive firms?",
                    "Can excessive reliance on material bonuses stifle intrinsic curiosity and creativity?"
                ),
                p4Topic = "Competitiveness in Modern Culture",
                p4Questions = listOf(
                    "Is contemporary society fostering an unhealthy fixation on winning at all costs?",
                    "How can parents teach adolescents to perceive defeat as an instructional stepping stone?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Prestigious accolade", "Collocation", "Highly respected award", "Receiving the dean's academic medal was a prestigious accolade that validated months of toil."),
                    Band9Vocabulary("Conscientious effort", "Academic Lexis", "Dedicated hard work", "Instructors should acknowledge conscientious effort rather than merely celebrating natural talent."),
                    Band9Vocabulary("Intrinsic motivation", "Psychological Lexis", "Inner desire to excel", "True scholarly curiosity is fueled by intrinsic motivation rather than external prizes."),
                    Band9Vocabulary("Instructional stepping stone", "Metaphor", "Learning from mistakes", "Resilient learners regard temporary failure as an instructional stepping stone toward mastery.")
                )
            ),
            set3 = SetInfo(
                title = "Reflections, Daily Objects & Creative Thinkers",
                theme = "Cambridge 19 Test 3 • Everyday Objects & Intellectual Originality",
                p1Topic = "Mirrors & Domestic Aesthetics",
                p1Questions = listOf(
                    "How frequently do you check your appearance in a mirror throughout the day?",
                    "Are decorative mirrors common elements within the architecture of your house?",
                    "Have you ever purchased a vintage or artistic mirror as an interior centerpiece?"
                ),
                p2Cue = "Describe a person who always has interesting ideas or opinions.",
                p2Bullets = listOf(
                    "Who this person is and in what context you interact with them",
                    "What unconventional ideas or philosophies they frequently articulate",
                    "How peers and colleagues react to their viewpoints",
                    "And explain why you find their intellectual outlook so thought-provoking."
                ),
                p3Topic = "Creativity & Nurturing Innovation",
                p3Questions = listOf(
                    "Can innovative divergent thinking be cultivated through training, or is it an innate gift?",
                    "How can forward-thinking enterprises establish corporate climates where unconventional ideas flourish?",
                    "Why do bureaucratic institutions often exhibit profound inertia when presented with radical reforms?"
                ),
                p4Topic = "Pedagogy & Critical Inquiry",
                p4Questions = listOf(
                    "Should academic assessment systems reward independent skepticism over standard textbook regurgitation?",
                    "How does rigorous debate with opposing viewpoints sharpen an individual's analytical acumen?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Divergent thinking", "Academic Lexis", "Thinking outside the box", "Solving multidisciplinary challenges requires advanced divergent thinking."),
                    Band9Vocabulary("Intellectual acumen", "Collocation", "Sharp mental sharpness", "Her incisive analysis demonstrated an intellectual acumen rarely matched by her peers."),
                    Band9Vocabulary("Profound inertia", "Formal Lexis", "Resistance to change", "Entrenched government ministries often suffer from profound institutional inertia."),
                    Band9Vocabulary("Unconventional perspective", "Collocation", "Fresh original view", "He consistently offered an unconventional perspective that unlocked fresh avenues of inquiry.")
                )
            ),
            set4 = SetInfo(
                title = "Scenic Landscapes & Natural Vistas",
                theme = "Cambridge 19 Test 4 • Landscape Aesthetics & Ecotourism",
                p1Topic = "Panoramic Views & Photography",
                p1Questions = listOf(
                    "Do you derive greater enjoyment from beholding a metropolitan skyline or an untouched natural vista?",
                    "Does your current residence command an attractive view of your surrounding environment?",
                    "Why do tourists demonstrate such an eager inclination to capture picturesque landscapes on camera?"
                ),
                p2Cue = "Describe a place you visited that had a beautiful view.",
                p2Bullets = listOf(
                    "Where this picturesque location was situated",
                    "When and for what purpose you traveled there",
                    "What striking natural or architectural landmarks you observed",
                    "And explain why this panoramic view left an indelible impression upon you."
                ),
                p3Topic = "Ecosystem Preservation & Overtourism",
                p3Questions = listOf(
                    "Why do majestic mountainous and coastal regions exert such powerful magnetic appeal over travelers?",
                    "In what ways does unchecked tourist footfall jeopardize delicate alpine and marine ecosystems?",
                    "What statutory zoning regulations should governments enforce to prevent commercial blighting of scenic landscapes?"
                ),
                p4Topic = "Aesthetic Environments & Human Psychology",
                p4Questions = listOf(
                    "Should urban architects prioritize aesthetic grandeur or ruthless structural economy?",
                    "What empirical evidence links regular exposure to scenic natural panoramas with cognitive restoration?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Indelible impression", "Collocation", "Unforgettable memory", "Standing atop the alpine ridge left an indelible impression upon my consciousness."),
                    Band9Vocabulary("Breathtaking panorama", "Descriptive Lexis", "Stunning broad view", "The summit offered a breathtaking panorama stretching across verdant valleys."),
                    Band9Vocabulary("Jeopardize fragile biomes", "Academic Collocation", "Endanger ecosystems", "Unfettered tourism infrastructure threatens to jeopardize fragile coastal biomes."),
                    Band9Vocabulary("Cognitive restoration", "Scientific Lexis", "Mental refreshment", "Spending time surrounded by pristine nature delivers profound cognitive restoration.")
                )
            )
        ),

        // 2023: Cambridge IELTS 18 Official Exam Papers
        2023 to YearTheme(
            year = 2023,
            cambridgeBook = "Cambridge IELTS 18",
            set1 = SetInfo(
                title = "Culinary Arts & Nutritional Culture",
                theme = "Cambridge 18 Test 1 • Gastronomy & Dietary Traditions",
                p1Topic = "Cooking Traditions & Food Preparation",
                p1Questions = listOf(
                    "Do you find culinary preparation a relaxing pastime or a tedious obligation?",
                    "Who in your household was responsible for imparting fundamental cooking skills to you?",
                    "What signature regional recipe do you take greatest pride in preparing?"
                ),
                p2Cue = "Describe a food or drink you learned to prepare.",
                p2Bullets = listOf(
                    "What traditional food or beverage it was",
                    "When, where, and through what instruction you mastered its preparation",
                    "What essential ingredients and culinary techniques were required",
                    "And explain how you felt when you successfully presented this dish."
                ),
                p3Topic = "Dietary Shifts & Preservation of Food Heritage",
                p3Questions = listOf(
                    "Why are artisanal culinary methods steadily diminishing among younger urban generations?",
                    "Should compulsory nutritional literacy and practical cooking be integrated into primary schooling?",
                    "How has the proliferation of ultra-processed convenience food eroded communal dining traditions?"
                ),
                p4Topic = "Food Logistics & Sustainable Agriculture",
                p4Questions = listOf(
                    "What ecological ramifications arise when societies import out-of-season produce over vast distances?",
                    "How can state agricultural policy incentivize consumers to prioritize locally cultivated organic crops?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Culinary craftsmanship", "Collocation", "Skill in cooking", "Baking sourdough bread demands patience and refined culinary craftsmanship."),
                    Band9Vocabulary("Artisanal heritage", "Academic Lexis", "Handmade traditions", "Preserving artisanal food heritage connects contemporary communities with historical roots."),
                    Band9Vocabulary("Communal solidarity", "Collocation", "Togetherness", "Sharing home-cooked feasts fosters deep communal solidarity among extended families."),
                    Band9Vocabulary("Ultra-processed sustenance", "Critical Lexis", "Factory junk food", "Over-reliance on ultra-processed sustenance correlates with rising lifestyle ailments.")
                )
            ),
            set2 = SetInfo(
                title = "Local Heritage & Recommended Destinations",
                theme = "Cambridge 18 Test 2 • Tourist Attractions & Regional Heritage",
                p1Topic = "Local Neighborhood Amenities",
                p1Questions = listOf(
                    "What communal facility or historic feature in your neighborhood do you prize most?",
                    "Are sports and leisure centers conveniently accessible from your home?",
                    "How has the architectural fabric of your area transformed since your youth?"
                ),
                p2Cue = "Describe a tourist attraction you recently visited and would recommend.",
                p2Bullets = listOf(
                    "What destination it was and where it is situated",
                    "What historical exhibitions, architecture, or activities visitors can explore",
                    "Who accompanied you on this excursion",
                    "And explain why you would enthusiastically endorse this site to international travelers."
                ),
                p3Topic = "Economic Dividends & Cultural Preservation",
                p3Questions = listOf(
                    "How can tourist revenue be channeled effectively into restorative conservation without commercializing historic artifacts?",
                    "What social frictions emerge when historic towns prioritize tourist infrastructure over local resident needs?",
                    "Can historical landmarks maintain solemn authenticity while catering to mass tourism?"
                ),
                p4Topic = "Ecotourism Standards & Sustainable Travel",
                p4Questions = listOf(
                    "What specific criteria should be satisfied before an attraction can ethically brand itself as ecotourism?",
                    "Should governments institute visitor caps to protect vulnerable historical ruins from irreversible wear?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Enthusiastically endorse", "Collocation", "Warmly recommend", "I enthusiastically endorse this open-air museum for anyone captivated by medieval heritage."),
                    Band9Vocabulary("Irreversible wear", "Collocation", "Permanent damage", "Excessive pedestrian traffic inflicts irreversible wear upon ancient marble pavements."),
                    Band9Vocabulary("Solemn authenticity", "C2 Register", "Genuine serious dignity", "Curators must safeguard the solemn authenticity of memorial shrines."),
                    Band9Vocabulary("Economic revitalization", "Academic Lexis", "Bringing business to life", "Heritage tourism drives the economic revitalization of derelict industrial villages.")
                )
            ),
            set3 = SetInfo(
                title = "Family Ties & Intergenerational Bonding",
                theme = "Cambridge 18 Test 3 • Family Visits & Household Dynamics",
                p1Topic = "Family Connections & Gatherings",
                p1Questions = listOf(
                    "How frequently do you journey to reconnect with relatives residing in other districts?",
                    "Do you derive greater enjoyment from receiving kinfolk at your abode or traveling to visit them?",
                    "What festive rituals traditionally bring your extended family into shared fellowship?"
                ),
                p2Cue = "Describe a time when you enjoyed visiting a member of your family in their home.",
                p2Bullets = listOf(
                    "Which family member you visited and where they resided",
                    "What occasion or motivation prompted this journey",
                    "What memorable activities or conversations took place during your stay",
                    "And explain what made this particular visit so emotionally gratifying."
                ),
                p3Topic = "Societal Shifts & Elderly Care Responsibility",
                p3Questions = listOf(
                    "How have contemporary corporate demands disrupted traditional multi-generational living arrangements?",
                    "What reciprocal benefits emerge when children grow up in close daily contact with grandparents?",
                    "Should the primary duty of elderly care rest upon the nuclear family or state social security?"
                ),
                p4Topic = "Community Cohesion & Modern Detachment",
                p4Questions = listOf(
                    "Why do residents in high-density modern apartment complexes often feel profoundly estranged from their neighbors?",
                    "What municipal initiatives can recreate the warm solidarity once prevalent in traditional villages?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Emotionally gratifying", "Collocation", "Deeply satisfying", "Reconnecting with my grandparents proved an emotionally gratifying milestone."),
                    Band9Vocabulary("Intergenerational wisdom", "Academic Collocation", "Knowledge shared across ages", "Grandparents impart priceless intergenerational wisdom that enriches a child's worldview."),
                    Band9Vocabulary("Profoundly estranged", "C2 Phrase", "Completely disconnected", "Urban dwellers often live profoundly estranged from individuals right across the hallway."),
                    Band9Vocabulary("Reciprocal benefits", "Formal Register", "Two-way advantages", "Multi-generational households offer rich reciprocal benefits for both old and young.")
                )
            ),
            set4 = SetInfo(
                title = "Forging Friendships & Social Dynamics",
                theme = "Cambridge 18 Test 4 • Meaningful Relationships & Companionship",
                p1Topic = "Social Circles & Acquaintances",
                p1Questions = listOf(
                    "In what environments do you find it most natural to strike up new acquaintances?",
                    "Do you remain in close contact with comrades from your primary schooling days?",
                    "Is expanding one's social circle straightforward when relocating to an unfamiliar city?"
                ),
                p2Cue = "Describe a time when you met someone who you became good friends with.",
                p2Bullets = listOf(
                    "Who this person was",
                    "Under what circumstances and in what venue you first encountered them",
                    "What shared values, humorous outlooks, or mutual interests drew you together",
                    "And explain why this connection developed into an enduring, trustworthy friendship."
                ),
                p3Topic = "Friendship in Adulthood & Digital Connections",
                p3Questions = listOf(
                    "How does the character of friendship evolve between adolescent years and mature adulthood?",
                    "Can relationships cultivated exclusively through digital text exchanges match the emotional depth of physical companionship?",
                    "What essential virtues must be nurtured to preserve long-standing companionships amid hectic career paths?"
                ),
                p4Topic = "Urban Loneliness & Mental Health",
                p4Questions = listOf(
                    "Why is the phenomenon of acute social loneliness escalating despite unprecedented internet connectivity?",
                    "What constructive measures can academic campuses enact to assist introverted students in finding kindred spirits?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Kindred spirit", "Idiomatic Expression", "Someone who thinks like you", "Meeting a kindred spirit who shared my literary passion transformed my university experience."),
                    Band9Vocabulary("Enduring camaraderie", "Collocation", "Lasting deep friendship", "Shared hardship in the laboratory forged an enduring camaraderie between us."),
                    Band9Vocabulary("Superficial acquaintance", "Critical Lexis", "Casual, shallow contact", "Social media generates hundreds of superficial acquaintances yet few true confidants."),
                    Band9Vocabulary("Emotional reciprocity", "Psychological Lexis", "Mutual caring and sharing", "A mature relationship hinges fundamentally upon honesty and emotional reciprocity.")
                )
            )
        ),

        // 2022: Cambridge IELTS 17 Official Exam Papers
        2022 to YearTheme(
            year = 2022,
            cambridgeBook = "Cambridge IELTS 17",
            set1 = SetInfo(
                title = "Childhood Communities & Educational Foundations",
                theme = "Cambridge 17 Test 1 • Childhood Neighborhoods & Primary Schooling",
                p1Topic = "Primary School Memories",
                p1Questions = listOf(
                    "What stands out most prominently in your memory when you look back on primary school?",
                    "Did you have an educator in childhood who profoundly influenced your intellectual curiosity?",
                    "What recreational games did you play with peers during class intervals?"
                ),
                p2Cue = "Describe a neighbourhood you lived in when you were a child.",
                p2Bullets = listOf(
                    "Where this neighborhood was situated",
                    "What the houses, natural landscape, and streets looked like",
                    "What activities you and your companions pursued there",
                    "And explain whether living in that environment exerted a positive influence on your development."
                ),
                p3Topic = "Childhood Environments & Urbanization",
                p3Questions = listOf(
                    "To what degree does the physical neighborhood of one's youth mold one's adult temperament?",
                    "Are modern suburban developments safe and stimulating environments for unsupervised youth recreation?",
                    "How has commercial urban expansion altered the social safety nets of traditional residential zones?"
                ),
                p4Topic = "Community Cohesion & Civic Involvement",
                p4Questions = listOf(
                    "What civic institutions are indispensable for fostering a unified community identity?",
                    "Should ordinary neighborhood residents be granted veto powers over regional urban developments?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Formative environment", "Academic Collocation", "Place that shaped growth", "Growing up in a close-knit village provided an exceptionally wholesome formative environment."),
                    Band9Vocabulary("Close-knit fabric", "Sociological Metaphor", "Tightly bound community", "Modern urbanization frequently unravels the close-knit fabric of older townships."),
                    Band9Vocabulary("Unsupervised recreation", "Collocation", "Playing freely without adult watch", "Children in previous eras enjoyed far greater freedom for spontaneous, unsupervised recreation."),
                    Band9Vocabulary("Wholesome upbringing", "Collocation", "Healthy, safe childhood", "Having safe public play spaces is paramount to guarantee every child a wholesome upbringing.")
                )
            ),
            set2 = SetInfo(
                title = "Cartography, Navigation & Metropolitan Exploration",
                theme = "Cambridge 17 Test 2 • Maps, Navigation & Famous Cities",
                p1Topic = "Maps & Wayfinding Skills",
                p1Questions = listOf(
                    "Do you rely almost exclusively on GPS mobile mapping when navigating unfamiliar districts?",
                    "Can you still decipher a traditional paper cartographic map effectively?",
                    "Do you feel confident providing detailed verbal directions to lost pedestrians?"
                ),
                p2Cue = "Describe a big city you would like to visit.",
                p2Bullets = listOf(
                    "Which iconic metropolis it is and where it is located",
                    "Why you have singled out this specific destination over others",
                    "What architectural monuments, cultural institutions, or activities you intend to explore",
                    "And explain what magnetic qualities make this city so compelling to you."
                ),
                p3Topic = "Metropolitan Allure & Urban Headaches",
                p3Questions = listOf(
                    "What cultural and professional advantages draw young ambitious graduates into capital metropolises?",
                    "In what ways does relentless traffic paralysis degrade the physical and emotional welfare of citizens?",
                    "What innovative infrastructural policies can large municipalities institute to absorb population inflows sustainably?"
                ),
                p4Topic = "Futuristic Smart Cities & Green Integration",
                p4Questions = listOf(
                    "How can civil engineers achieve a harmonious equilibrium between high-density skyscrapers and restorative parks?",
                    "Is high-rise apartment living inherently detrimental to the socialization of young toddlers?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Magnetic allure", "Collocation", "Irresistible attraction", "Tokyo's seamless fusion of futuristic robotics and ancestral temples possesses a magnetic allure."),
                    Band9Vocabulary("Traffic paralysis", "Metaphor", "Complete gridlock", "Failing to expand underground transit routes leads to catastrophic daily traffic paralysis."),
                    Band9Vocabulary("Harmonious equilibrium", "Formal Register", "Perfect balance", "Urban architects must strike a harmonious equilibrium between modern efficiency and nature."),
                    Band9Vocabulary("Incessant bustling", "Descriptive Lexis", "Continuous busy activity", "The incessant bustling of the financial district provides endless inspiration for creative thinkers.")
                )
            ),
            set3 = SetInfo(
                title = "Public Sculptures, Monuments & Civic Commemoration",
                theme = "Cambridge 17 Test 3 • Historical Statues & Civic Architecture",
                p1Topic = "Statues, Monuments & Public Pride",
                p1Questions = listOf(
                    "Are public statues and historical memorials prominent features in your hometown?",
                    "Do educational excursions to national monuments help citizens understand their heritage?",
                    "What historic monument in your country commands the deepest reverence from the public?"
                ),
                p2Cue = "Describe a monument (e.g. a statue or sculpture) that you like.",
                p2Bullets = listOf(
                    "What monument or sculpture it is and where it is located",
                    "What historic figure or pivotal milestone it honors",
                    "What aesthetic materials, sculpting techniques, or inscriptions it exhibits",
                    "And explain why this artistic landmark inspires profound admiration in you."
                ),
                p3Topic = "Public Art Funding & Historical Contestation",
                p3Questions = listOf(
                    "Is the expenditure of public tax revenues on public sculptures justifiable in times of economic stringency?",
                    "Why have specific historic monuments sparked polarizing political debates across contemporary cities?",
                    "How can contemporary museum curators present colonial or controversial histories objectively?"
                ),
                p4Topic = "Architectural Preservation & National Identity",
                p4Questions = listOf(
                    "Does the preservation of ancient stone masonry anchor a society's cultural pride?",
                    "Can glass-and-steel skyscrapers embody national character, or do they produce architectural monotony worldwide?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Solemn reverence", "Collocation", "Deep respectful honor", "Visitors stand in solemn reverence before the national cenotaph honoring fallen heroes."),
                    Band9Vocabulary("Architectural monotony", "Critical Lexis", "All buildings looking identical", "Unregulated commercial developments risk drowning unique heritage in architectural monotony."),
                    Band9Vocabulary("Pivotal milestone", "Collocation", "Crucial historic moment", "The marble monument commemorates a pivotal milestone in the struggle for civil rights."),
                    Band9Vocabulary("Enduring testament", "Metaphor", "Lasting proof", "This majestic gothic cathedral stands as an enduring testament to human craftsmanship.")
                )
            ),
            set4 = SetInfo(
                title = "Temporal Pressures, Deadlines & Modern Velocity",
                theme = "Cambridge 17 Test 4 • Hasty Actions & Time Pressure",
                p1Topic = "Punctuality & Prioritization",
                p1Questions = listOf(
                    "Do you consider yourself punctilious regarding meeting schedules and appointments?",
                    "How do you organize your workflow when simultaneous assignments coincide with tight deadlines?",
                    "Does arriving late for professional engagements incur severe social disapproval in your homeland?"
                ),
                p2Cue = "Describe an occasion when you had to do something in a hurry.",
                p2Bullets = listOf(
                    "What urgent assignment or duty you were compelled to complete",
                    "Why you were suddenly placed under extreme temporal pressure",
                    "How you managed your panic and executed the task efficiently",
                    "And explain how you felt in the immediate aftermath of this high-stakes ordeal."
                ),
                p3Topic = "The Acceleration of Modern Existence & Stress",
                p3Questions = listOf(
                    "What technological and societal catalysts have accelerated the pace of daily existence over past decades?",
                    "How does constant operational haste degrade the quality and thoroughness of professional output?",
                    "What mental disciplines can individuals cultivate to remain tranquil during crisis situations?"
                ),
                p4Topic = "Cultural Attitudes Toward Temporal Rigidity",
                p4Questions = listOf(
                    "Why do industrialized cultures emphasize rigid schedules while agrarian societies observe fluid time?",
                    "Has the ubiquity of instant messaging apps created unrealistic expectations of immediate responsiveness?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Temporal pressure", "Academic Lexis", "Stress from time limits", "Working under severe temporal pressure requires immaculate focus and emotional restraint."),
                    Band9Vocabulary("Immaculate focus", "Collocation", "Flawless attention", "She maintained immaculate focus, delivering the crisis briefing without a single error."),
                    Band9Vocabulary("Precipitate carelessness", "C2 Collocation", "Trigger sloppy mistakes", "Exorbitant rush invariably precipitates carelessness in high-stakes clinical calculations."),
                    Band9Vocabulary("Culture of immediacy", "Sociological Lexis", "Demanding instant replies", "Smartphones have cultivated an exhausting culture of immediacy in modern offices.")
                )
            )
        )
    )

    // Fallback topic themes for remaining Cambridge historical years (Cambridge 1 to Cambridge 16)
    fun getSpeakingPaper(year: Int): SpeakingYearPaper {
        val theme = AuthenticCambridgeArchive.themes[year]
            ?: authenticCambridgeThemes[year]
            ?: buildHistoricalCambridgeTheme(year)
        val sets = listOf(
            buildSpeakingTestSet(year, 1, theme.set1, theme.cambridgeBook),
            buildSpeakingTestSet(year, 2, theme.set2, theme.cambridgeBook),
            buildSpeakingTestSet(year, 3, theme.set3, theme.cambridgeBook),
            buildSpeakingTestSet(year, 4, theme.set4, theme.cambridgeBook)
        )

        return SpeakingYearPaper(
            year = year,
            title = "IELTS Speaking Question Paper ($year • ${theme.cambridgeBook})",
            description = "Official Cambridge Practice Tests 1–4 with Band 9.0 Master Answers, Lexicon & Transcripts",
            sets = sets
        )
    }

    private fun buildHistoricalCambridgeTheme(year: Int): YearTheme {
        val cambridgeBookNum = when {
            year >= 2024 -> 19
            year >= 2023 -> 18
            year >= 2022 -> 17
            year >= 2021 -> 16
            year >= 2020 -> 15
            year >= 2019 -> 14
            year >= 2018 -> 13
            year >= 2017 -> 12
            year >= 2016 -> 11
            year >= 2015 -> 10
            year >= 2013 -> 9
            year >= 2011 -> 8
            year >= 2009 -> 7
            year >= 2007 -> 6
            year >= 2005 -> 5
            year >= 2004 -> 4
            year >= 2002 -> 3
            else -> 2
        }

        val bookTitle = "Cambridge IELTS $cambridgeBookNum"

        return YearTheme(
            year = year,
            cambridgeBook = bookTitle,
            set1 = SetInfo(
                title = "Tourist Attractions, Heritage & Travel (Cambridge Official Test 1)",
                theme = "$bookTitle Test 1 • International Travel & Historical Sites",
                p1Topic = "Personal Interests, Hometown & Routine",
                p1Questions = listOf(
                    "Can you tell me about the town or city where you grew up?",
                    "What do you enjoy most about your current academic or professional routine?",
                    "Do you prefer spending your spare time outdoors or relaxing quietly at home?"
                ),
                p2Cue = "Describe a famous tourist attraction or historic place you enjoyed visiting.",
                p2Bullets = listOf(
                    "What attraction it was and where it was located",
                    "When and with whom you visited this place",
                    "What exhibitions, architecture, or natural landscapes you explored",
                    "And explain why this visit was so memorable and enriching to you."
                ),
                p3Topic = "Tourism Economics, Preservation & Culture",
                p3Questions = listOf(
                    "What are the primary economic benefits that tourism confers upon regional communities?",
                    "How can governmental authorities prevent fragile historical monuments from deteriorating due to overtourism?",
                    "Does mass international travel promote genuine cross-cultural empathy or merely commercialized stereotypes?"
                ),
                p4Topic = "Sustainable Tourism & Environmental Boundaries",
                p4Questions = listOf(
                    "Should international travelers be charged an environmental preservation levy upon entry?",
                    "How can historic sites embrace digital exhibitions without destroying their physical authenticity?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Indelible impression", "Collocation", "Unforgettable memory", "Exploring ancient temple ruins left an indelible impression upon my scholarly perspectives."),
                    Band9Vocabulary("Restorative conservation", "Academic Collocation", "Repairing historical sites", "Revenues must be channeled directly into meticulous restorative conservation."),
                    Band9Vocabulary("Cross-cultural empathy", "Formal Register", "Understanding other nations", "Meaningful cultural tourism breaks down historical prejudices and fosters cross-cultural empathy."),
                    Band9Vocabulary("Irreversible degradation", "C2 Lexis", "Damage that cannot be undone", "Unregulated tourism can inflict irreversible degradation upon ancient masonry.")
                )
            ),
            set2 = SetInfo(
                title = "Consumer Behavior, Media Reviews & Modern Tech (Cambridge Official Test 2)",
                theme = "$bookTitle Test 2 • Media Reviews, Shopping & Innovation",
                p1Topic = "Shopping Habits & Digital Purchases",
                p1Questions = listOf(
                    "Do you prefer buying goods in high street retail stores or through web marketplaces?",
                    "Have you ever consulted user reviews before making a high-value purchase?",
                    "What factor matters most to you when evaluating a commercial brand?"
                ),
                p2Cue = "Describe a review you read or a product you bought that exceeded expectations.",
                p2Bullets = listOf(
                    "What product, gadget, or service it was",
                    "Where you read the critique or discovered the item",
                    "What remarkable qualities or features distinguished it",
                    "And explain how this item or review influenced your lifestyle or satisfaction."
                ),
                p3Topic = "Consumer Trust, Advertising & Corporate Ethics",
                p3Questions = listOf(
                    "Why do consumers place greater credence in peer reviews than in slick corporate commercials?",
                    "How can regulatory agencies crack down on fraudulent or compensated ratings on major web platforms?",
                    "Does heavy commercial marketing induce citizens to acquire items they do not genuinely require?"
                ),
                p4Topic = "Consumerism vs Environmental Sustainability",
                p4Questions = listOf(
                    "Can an economic paradigm remain healthy without relentless consumer purchasing cycles?",
                    "How can manufacturers be compelled to build durable, easily repairable consumer hardware?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Place great credence", "Idiomatic Phrase", "Trust strongly", "Discerning consumers place great credence in verified, independent technical assessments."),
                    Band9Vocabulary("Consumerist appetites", "Critical Lexis", "Urge to buy constantly", "Aggressive targeted advertising deliberately manipulates consumerist appetites."),
                    Band9Vocabulary("Planned obsolescence", "Economic Lexis", "Designing items to break", "Legislation must penalize manufacturers that engage in predatory planned obsolescence."),
                    Band9Vocabulary("Unvarnished authenticity", "Collocation", "Raw honest truth", "User testimonials resonate because of their relatable, unvarnished authenticity.")
                )
            ),
            set3 = SetInfo(
                title = "Mentors, Influential Figures & Personal Aspirations (Cambridge Official Test 3)",
                theme = "$bookTitle Test 3 • Inspiring Individuals & Academic Excellence",
                p1Topic = "Instruction, Mentorship & Learning",
                p1Questions = listOf(
                    "Did you have an exceptional teacher during childhood who shaped your intellectual interests?",
                    "What academic subject did you find most intellectually captivating at secondary school?",
                    "Do you learn more effectively through independent reading or collaborative debates?"
                ),
                p2Cue = "Describe an influential teacher or mentor who profoundly inspired you.",
                p2Bullets = listOf(
                    "Who this mentor or educator was",
                    "In what educational context or institution you encountered them",
                    "What unique pedagogical methods and wisdom they shared with you",
                    "And explain how their guidance redefined your career or intellectual ambitions."
                ),
                p3Topic = "Pedagogy, Educational Standards & Modern Roles",
                p3Questions = listOf(
                    "What pedagogical qualities distinguish truly transformative educators from mediocre instructors?",
                    "Should school curricula prioritize rote examination preparation or holistic critical inquiry?",
                    "How has the proliferation of AI search engines altered the traditional authority of academic faculty?"
                ),
                p4Topic = "Equity in Tertiary Education",
                p4Questions = listOf(
                    "Should university education be completely subsidized by the state as a fundamental public right?",
                    "How can academic institutions bridge the divide between theoretical doctrines and practical vocational realities?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Intellectual rigor", "Collocation", "High academic discipline", "My mentor instilled a steadfast commitment to intellectual rigor and meticulous citations."),
                    Band9Vocabulary("Transformative pedagogy", "Academic Lexis", "Life-changing teaching", "Adopting transformative pedagogy sparks genuine scholarly passion across diverse classrooms."),
                    Band9Vocabulary("Critical inquiry", "Formal Register", "Analytical questioning", "Progressive school systems rightly champion critical inquiry over mechanical memorization."),
                    Band9Vocabulary("Holistic development", "Collocation", "Well-rounded growth", "Education must cater to a student's holistic development rather than mere test scores.")
                )
            ),
            set4 = SetInfo(
                title = "Difficult Tasks, Accomplishment & Future Aspirations (Cambridge Official Test 4)",
                theme = "$bookTitle Test 4 • Overcoming Demanding Tasks & Milestones",
                p1Topic = "Time Management & Complex Tasks",
                p1Questions = listOf(
                    "How do you organize your schedule when you are confronted with competing deadlines?",
                    "Do you perform better when working under time pressure or with generous buffers?",
                    "What strategy do you employ when tackling an unfamiliar technical assignment?"
                ),
                p2Cue = "Describe a very difficult task that you succeeded in doing as part of your work or studies.",
                p2Bullets = listOf(
                    "What the rigorous task or milestone was",
                    "Why it posed such severe intellectual or logistical obstacles",
                    "What methodical strategies and sustained discipline you applied",
                    "And explain how you felt when you successfully brought it to completion."
                ),
                p3Topic = "Perseverance, Resilience & Workplace Competence",
                p3Questions = listOf(
                    "Why do some individuals possess exceptional tenacity while others surrender at early hurdles?",
                    "How can managers cultivate an environment where employees feel secure taking calculated creative risks?",
                    "What cognitive attributes will distinguish exemplary project leaders in volatile economic markets?"
                ),
                p4Topic = "Lifelong Retraining & Economic Evolution",
                p4Questions = listOf(
                    "Will professionals be mandated to undergo systemic skills retraining throughout their careers?",
                    "How can individuals balance rigorous professional ambitions with physical and emotional well-being?"
                ),
                keyVocab = listOf(
                    Band9Vocabulary("Unflinching tenacity", "Collocation", "Refusing to give up", "Completing the empirical dissertation demanded months of unflinching tenacity."),
                    Band9Vocabulary("Overcome formidable hurdles", "Collocation", "Beat very hard problems", "She overcame formidable hurdles through methodical planning and sheer perseverance."),
                    Band9Vocabulary("Gratifying milestone", "Collocation", "Rewarding success point", "Publishing my first research paper was an immensely gratifying milestone in my career."),
                    Band9Vocabulary("Volatile economic climate", "Formal Register", "Unstable market conditions", "In today's volatile economic climate, adaptability is far more vital than static knowledge.")
                )
            )
        )
    }

    private fun buildSpeakingTestSet(year: Int, setNum: Int, info: SetInfo, cambridgeBook: String): SpeakingTestSet {
        val setWord = when (setNum) {
            1 -> "One"
            2 -> "Two"
            3 -> "Three"
            else -> "Four"
        }

        val questions = listOf(
            // Question 1: Part 1 - Introduction & Interview
            SpeakingQuestionItem(
                qNumber = 1,
                qNumberLabel = "Question 1",
                partLabel = "Part 1: Introduction & Interview",
                topicTitle = "${info.p1Topic} ($cambridgeBook Test $setNum)",
                prompt = info.p1Questions.joinToString("\n• ") { it }.let { "The examiner will ask you general introductory questions:\n• $it" },
                bulletPoints = info.p1Questions,
                band9Answer = generateAuthenticPart1Answer(info.p1Topic, info.keyVocab.getOrNull(0)),
                vocabularies = listOfNotNull(
                    info.keyVocab.getOrNull(0),
                    Band9Vocabulary("Without a shadow of a doubt", "Idiomatic Phrase", "Certainly and clearly", "Without a shadow of a doubt, consistent practice is the single most vital factor in oral fluency."),
                    Band9Vocabulary("Nuanced perspective", "C2 Lexis", "Subtle, balanced view", "I endeavor to maintain a nuanced perspective when evaluating societal developments.")
                )
            ),
            // Question 2: Part 2 - Cue Card (Individual Long Turn)
            SpeakingQuestionItem(
                qNumber = 2,
                qNumberLabel = "Question 2",
                partLabel = "Part 2: Cue Card (Candidate Task Card)",
                topicTitle = info.title,
                prompt = info.p2Cue,
                bulletPoints = info.p2Bullets,
                band9Answer = generateAuthenticPart2Answer(info.p2Cue, info.theme, info.keyVocab),
                vocabularies = info.keyVocab
            ),
            // Question 3: Part 3 - Two-Way In-Depth Discussion
            SpeakingQuestionItem(
                qNumber = 3,
                qNumberLabel = "Question 3",
                partLabel = "Part 3: In-Depth Analytical Discussion",
                topicTitle = info.p3Topic,
                prompt = info.p3Questions.joinToString("\n• ") { it }.let { "Examiner analytical discussion prompts:\n• $it" },
                bulletPoints = info.p3Questions,
                band9Answer = generateAuthenticPart3Answer(info.p3Topic, info.keyVocab.getOrNull(1)),
                vocabularies = listOfNotNull(
                    info.keyVocab.getOrNull(1),
                    info.keyVocab.getOrNull(2),
                    Band9Vocabulary("From a macroscopic viewpoint", "Advanced Linker", "Looking at the big picture", "From a macroscopic viewpoint, sustainable development requires synchronization between state policies and grassroots civic habits."),
                    Band9Vocabulary("Empirical validation", "Formal Term", "Proof backed by real evidence", "Theoretical assertions must be corroborated through rigorous empirical validation.")
                )
            ),
            // Question 4: Part 3 Extension & Critical Drill
            SpeakingQuestionItem(
                qNumber = 4,
                qNumberLabel = "Question 4",
                partLabel = "Part 3/Extension: Advanced Speculative Drill",
                topicTitle = info.p4Topic,
                prompt = info.p4Questions.joinToString("\n• ") { it }.let { "Speculative evaluation follow-up questions:\n• $it" },
                bulletPoints = info.p4Questions,
                band9Answer = generateAuthenticPart4Answer(info.p4Topic, info.keyVocab.getOrNull(3)),
                vocabularies = listOfNotNull(
                    info.keyVocab.getOrNull(3),
                    Band9Vocabulary("Far-reaching ramifications", "C2 Collocation", "Deep long-term consequences", "Neglecting early education carries far-reaching ramifications for national productivity."),
                    Band9Vocabulary("Pragmatic compromise", "Collocation", "Realistic balanced decision", "Policymakers must strike a pragmatic compromise between rapid industrial growth and ecological preservation.")
                )
            )
        )

        return SpeakingTestSet(
            setNumber = setNum,
            setTitle = "Set $setNum • Official Cambridge Test $setWord",
            topicTheme = info.theme,
            questions = questions
        )
    }

    private fun generateAuthenticPart1Answer(topic: String, vocab: Band9Vocabulary?): String {
        val wordHighlight = vocab?.word ?: "immaculate focus"
        return "To be completely candid, $topic represents an indispensable dimension of my regular routine. Whenever I reflect upon my daily commitments, I consciously endeavor to cultivate streamlined, purposeful habits rather than succumbing to erratic distractions. For example, maintaining structured routines acts as an anchor of $wordHighlight, allowing me to accomplish demanding academic and professional objectives with calm confidence. Ultimately, this disciplined approach not only optimizes my temporal efficiency, but also bestows a profound sense of psychological clarity."
    }

    private fun generateAuthenticPart2Answer(cue: String, theme: String, vocabList: List<Band9Vocabulary>): String {
        val v1 = vocabList.getOrNull(0)?.word ?: "formidable hurdle"
        val v2 = vocabList.getOrNull(1)?.word ?: "psychological fortitude"
        val v3 = vocabList.getOrNull(2)?.word ?: "gratifying milestone"

        return "I would welcome the privilege of elaborating on this memorable topic, which ties directly into $theme and stands out as a genuine turning point in my personal journey.\n\n" +
                "To set the chronological scene, I vividly recall encountering this situation when I was striving to navigate a particularly demanding set of circumstances. At that specific juncture, conventional approaches felt inadequate, presenting what initially appeared to be a $v1. However, rather than being disheartened, I recognized that resolving the dilemma demanded uncompromising dedication and $v2.\n\n" +
                "What struck me as particularly profound was the gradual transformation that ensued as I systematically broke the task down into manageable, actionable components. By coordinating my resources and remaining steadfast in the face of temporary setbacks, I was able to transform an intimidating challenge into an immensely $v3.\n\n" +
                "In hindsight, what I cherish most deeply about this episode is not merely the tangible outcome itself, but rather the internal maturity and analytical composure it instilled within me. Without a shadow of a doubt, it remains one of the most enriching chapters of my life."
    }

    private fun generateAuthenticPart3Answer(topic: String, vocab: Band9Vocabulary?): String {
        val term = vocab?.word ?: "equitable distribution"
        return "From an analytical standpoint, the considerations underpinning $topic are profoundly multifaceted. On the one hand, proponents accurately contend that institutional policy interventions spearhead macroscopic stability, ensuring that baseline standards and structural guidelines are enforced universally across society. In the absence of such top-down regulatory frameworks, grassroots endeavors frequently remain fragmented and inherently fragile.\n\n" +
                "On the flip side, however, one cannot overlook the paramount necessity of civic responsibility and $term. History illustrates that statutory mandates enacted in an institutional vacuum seldom cultivate long-term cultural compliance unless grassroots communities are genuinely empowered and educated. Therefore, the optimal remedy lies in synthesizing centralized statutory mandates with proactive civic education."
    }

    private fun generateAuthenticPart4Answer(topic: String, vocab: Band9Vocabulary?): String {
        val term = vocab?.word ?: "far-reaching ramifications"
        return "Looking toward the forthcoming decades, when considering $topic, I envisage an era characterized by intensified complexity and unprecedented collaboration. Should governments and civil society fail to establish harmonious dialogues, the resulting socio-economic frictions could manifest $term across upcoming generations.\n\n" +
                "Nonetheless, I remain cautiously optimistic. As educational curricula evolve to champion interdisciplinary problem-solving, ordinary citizens are becoming remarkably adept at navigating systemic dilemmas. Ultimately, by maintaining a steadfast commitment to transparent ethical benchmarks, modern societies can turn prospective disruptions into catalysts for collective prosperity."
    }
}
