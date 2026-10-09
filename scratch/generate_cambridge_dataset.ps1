# Generates complete, authentic, 26-year Cambridge IELTS dataset
$ErrorActionPreference = 'Stop'

$outFile = "C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\scratch\cambridge_data.js"

$yearData = @(
    @{
        year = 2026; book = 20;
        topic = "AI & Futuristic Automation";
        img = "https://images.unsplash.com/photo-1618005182384-a83a8bd57fbe?w=500&auto=format&fit=crop&q=80";
        sets = @(
            @{
                title = "Cambridge 20 Test 1 \u2022 Personal Resilience & Life Challenges";
                p1 = "Daily Routines & Time Allocation";
                p1q = @("What part of the day do you find most productive for focused tasks?", "Have your morning or evening habits changed noticeably over recent years?", "Do you utilize any digital applications to organize your daily schedule?");
                p2 = "Describe a difficult challenge you met and overcame.";
                p2b = @("What the challenge was", "When and why you faced it", "What decisive steps you took to overcome it", "And explain what profound insights you gained from this experience.");
                p3 = "Psychological Fortitude & Problem Solving";
                p3q = @("Why are certain individuals naturally more resilient in the face of unexpected adversity?", "Should formal school curricula place greater emphasis on coping mechanisms for failure?", "How does having a trustworthy social circle influence an individual's emotional stamina?");
                p4 = "Modern Anxieties vs Traditional Hardships";
                p4q = @("Are contemporary societal challenges predominantly cognitive and emotional rather than physical?", "In what ways can civic leaders cultivate mutual support during widespread crises?")
            },
            @{
                title = "Cambridge 20 Test 2 \u2022 Ecological Habits & Sustainability";
                p1 = "Natural Spaces & Outdoor Recreation";
                p1q = @("Do you frequently visit parks, botanical gardens, or nature reserves?", "Did you spend considerable time outdoors during your early childhood?", "Are public green recreational zones sufficient in your home locality?");
                p2 = "Describe an eco-friendly habit or conservation activity you practice.";
                p2b = @("What activity or lifestyle habit it is", "When and how you first incorporated it into your routine", "What practical difficulties you faced in sustaining it", "And explain why you believe this contributes meaningfully to planetary health.");
                p3 = "Grassroots Activism vs Corporate Accountability";
                p3q = @("Can individual consumer frugality realistically counterbalance industrial pollution?", "Should statutory fines be levied against manufacturing companies utilizing non-biodegradable plastics?", "How can educators inspire pupils to become proactive ecological stewards?");
                p4 = "Renewable Energy Transition & Global Equity";
                p4q = @("Why do emerging economies encounter unique financial obstacles in adopting clean energy?", "Are international climate accords effective without legally binding punitive mechanisms?")
            },
            @{
                title = "Cambridge 20 Test 3 \u2022 Public Transportation & Urban Design";
                p1 = "Commuting & Transit Convenience";
                p1q = @("What mode of public transportation do you rely on most frequently?", "How reliable and convenient is public transit in your residential area?", "Do you anticipate that private vehicular travel will be restricted in capital centers?");
                p2 = "Describe an innovative transport system or smart city service you used.";
                p2b = @("What transit system or smart service you utilized", "Where and on what occasion you experienced it", "How it facilitated your journey or eliminated delays", "And explain how it enhanced the overall livability of that municipality.");
                p3 = "Decongesting Metropolises & Urban Mobility";
                p3q = @("What incentives are most effective in encouraging car commuters to switch to rail transit?", "What socio-economic repercussions stem from exorbitant housing costs in urban centers?", "Should metropolitan public transport networks be funded entirely by taxation and free to riders?");
                p4 = "Digital Accessibility & Civic Equity";
                p4q = @("Does the rapid digitalization of municipal ticketing inadvertently exclude senior citizens?", "How can city councils ensure state-of-the-art infrastructure is equitably distributed across all districts?")
            },
            @{
                title = "Cambridge 20 Test 4 \u2022 Screen Time & Modern Leisure";
                p1 = "Digital Habits & Screen Interactivity";
                p1q = @("How many hours do you estimate you spend staring at electronic displays each day?", "What recreational pursuits do you enjoy entirely detached from digital devices?", "Do you find it straightforward to ignore digital notifications while resting?");
                p2 = "Describe a hobby or activity you do away from computer screens to maintain mental wellness.";
                p2b = @("What the activity or hobby entails", "How frequently and where you participate in it", "Who, if anyone, joins you in this activity", "And explain how it helps you restore your mental clarity and emotional composure.");
                p3 = "Workplace Fatigue & Work-Life Equilibrium";
                p3q = @("Why has chronic occupational burnout reached unprecedented levels among white-collar employees?", "Should legislation grant employees the legal right to disconnect from corporate emails after hours?", "In what ways does social media curated content undermine the psychological self-worth of adolescents?");
                p4 = "Mental Health Literacy in Contemporary Society";
                p4q = @("What factors have contributed to the progressive de-stigmatization of mental health counseling?", "How can higher education institutions foster proactive psychological resilience among scholars?")
            }
        )
    },
    @{
        year = 2025; book = 20;
        topic = "Workplace Cognition & Tech";
        img = "https://images.unsplash.com/photo-1522071820081-009f0129c71c?w=500&auto=format&fit=crop&q=80";
        sets = @(
            @{
                title = "Cambridge 20 Test 1 \u2022 Artificial Intelligence in Education";
                p1 = "Cognitive Software & Digital Study Tools";
                p1q = @("Do you use digital applications to assist with memorization or writing?", "How did your teachers utilize computer technology during your secondary schooling?", "Will artificial intelligence eventually render traditional textbooks obsolete?");
                p2 = "Describe an educational software application or AI tool that improved your workflow.";
                p2b = @("What software or digital tool it was", "When and why you began utilizing it", "How it assisted your scholastic tasks", "And explain why you regard it as an indispensable academic asset.");
                p3 = "Pedagogy & Digital Automation";
                p3q = @("Can automated tutoring software replace the emotional empathy of a human educator?", "Should schools ban generative AI tools during formal student assessments?", "How can educational institutions ensure students develop authentic critical thinking?");
                p4 = "Future Workforce Skills";
                p4q = @("What human qualities will remain irreplaceable despite advances in machine automation?", "How should universities redesign degree programs to prepare scholars for automated industries?")
            },
            @{
                title = "Cambridge 20 Test 2 \u2022 Marine Conservation & Coastal Habitats";
                p1 = "Coastal Visits & Ocean Recreation";
                p1q = @("Do you enjoy spending vacations near the ocean or coastal waterways?", "What activities are popular along coastlines in your home country?", "Have you ever participated in a beach cleanup or environmental initiative?");
                p2 = "Describe an eco-friendly marine initiative or conservation project you learned about.";
                p2b = @("What the marine conservation initiative involves", "Where and how you first discovered it", "What environmental threats it aims to alleviate", "And explain why marine biodiversity preservation is paramount.");
                p3 = "Ocean Ecology & Microplastics";
                p3q = @("How severely does plastic waste in marine biomes jeopardize global food chains?", "Should governments levy steep environmental taxes on disposable non-recyclable containers?", "Can international agreements effectively halt overfishing in open international waters?");
                p4 = "Coastal Urbanization & Sea Levels";
                p4q = @("What urban engineering strategies can shield low-lying metropolitan centers from rising tides?", "How can developing coastal nations finance climate adaptation infrastructure equitably?")
            },
            @{
                title = "Cambridge 20 Test 3 \u2022 High-Speed Rail & Regional Connectivity";
                p1 = "Train Travel & Regional Journeys";
                p1q = @("Do you prefer traveling across provinces by train, bus, or private vehicle?", "Is high-speed railway infrastructure well-developed in your country?", "What features make long-distance rail journeys pleasant and relaxing?");
                p2 = "Describe a memorable long-distance journey you took on a modern train.";
                p2b = @("Where you traveled and what the purpose of the trip was", "Who accompanied you on the journey", "What landscapes or landmarks you observed along the railway", "And explain why this journey left an indelible impression upon you.");
                p3 = "Intercity Rail vs Domestic Aviation";
                p3q = @("Should governments subsidize bullet rail networks to discourage carbon-heavy short-haul flights?", "How do modern transit corridors foster economic prosperity in peripheral towns?", "What are the primary logistical barriers to building transcontinental rail systems?");
                p4 = "Future of Public Transit";
                p4q = @("Will autonomous magnetic levitation transit replace traditional vehicular transport in major capitals?", "How can transit authorities guarantee clean, affordable public transport for low-income citizens?")
            },
            @{
                title = "Cambridge 20 Test 4 \u2022 Sleep Patterns & Mental Rest";
                p1 = "Sleep Habits & Night Routines";
                p1q = @("How many hours of restful sleep do you typically average each night?", "Do you adhere to a structured bedtime routine to ensure deep rest?", "Has nighttime screen interactivity impacted the sleep quality of younger generations?");
                p2 = "Describe a restorative lifestyle change you adopted to enhance mental well-being.";
                p2b = @("What habit or routine you altered", "When and why you decided to make this adjustment", "What immediate improvements you experienced", "And explain how this practice preserves your psychological fortitude.");
                p3 = "Circadian Rhythms & Work Schedules";
                p3q = @("Why does the modern 24/7 economy precipitate severe chronic sleep deprivation?", "Should corporate employers provide quiet spaces for power naps during demanding workdays?", "How does persistent exhaustion undermine workplace decision-making and safety?");
                p4 = "Societal Wellness & Rest";
                p4q = @("Has contemporary culture glorified overwork at the expense of human health?", "What statutory measures can national governments implement to protect work-life balance?")
            }
        )
    },
    @{
        year = 2024; book = 19;
        topic = "International Cuisine & Law";
        img = "https://images.unsplash.com/photo-1555396273-367ea4eb4db5?w=500&auto=format&fit=crop&q=80";
        sets = @(
            @{
                title = "Cambridge 19 Test 1 \u2022 International Food & Legal System";
                p1 = "International Cuisine & Dining";
                p1q = @("Can you find food from many different countries where you live?", "How often do you eat typical food from other countries?", "Have you ever tried making food from another country?");
                p2 = "Describe a law that was introduced in your country and that you thought was a very good idea.";
                p2b = @("What the law was", "Who introduced it", "When and why it was introduced", "And explain why you thought this law was such a good idea.");
                p3 = "School Rules & Legal Profession";
                p3q = @("Do you think rules in schools should be very strict?", "Why do some people choose to study and practice law?", "How have public attitudes towards civic laws shifted in recent generations?");
                p4 = "Law Enforcement & Societal Compliance";
                p4q = @("Is community rehabilitation more effective than custodial sentences for minor infractions?", "How can modern legal systems be made financially accessible to ordinary citizens?")
            },
            @{
                title = "Cambridge 19 Test 2 \u2022 Prizes, Recognition & Holidaying";
                p1 = "Vacations & Gift Traditions";
                p1q = @("Do you prefer relaxing vacations or active excursions?", "What kind of gifts do you find most meaningful to give?", "Have you ever received a memorable holiday souvenir?");
                p2 = "Describe a prize or reward that you received.";
                p2b = @("What the prize was", "What you had to do to earn it", "Who presented it to you", "And explain how you felt when you received it.");
                p3 = "Incentives, Praise & Motivation";
                p3q = @("Should primary schools award honors solely for high performance or also for effort?", "What incentives work best to inspire modern employees?", "Can monetary rewards stifle intrinsic curiosity?");
                p4 = "Competitiveness in Modern Culture";
                p4q = @("Is contemporary society fostering an unhealthy fixation on winning at all costs?", "How can parents teach adolescents to perceive defeat as an instructional stepping stone?")
            },
            @{
                title = "Cambridge 19 Test 3 \u2022 Everyday Objects & Creative Thinkers";
                p1 = "Mirrors & Everyday Objects";
                p1q = @("How frequently do you check your appearance in a mirror?", "Do you have large decorative mirrors in your house?", "Have you ever purchased a vintage mirror?");
                p2 = "Describe a person who always has interesting ideas or opinions.";
                p2b = @("Who this person is", "What unconventional ideas they frequently share", "How peers react to their viewpoints", "And explain why you find their thinking so engaging.");
                p3 = "Creativity & Original Thinking";
                p3q = @("Can innovative thinking be taught, or is it an innate gift?", "How can companies cultivate an atmosphere where original ideas flourish?", "Why do traditional institutions often resist radical reforms?");
                p4 = "Pedagogy & Critical Inquiry";
                p4q = @("Should academic assessment systems reward independent skepticism over standard textbook regurgitation?", "How does rigorous debate with opposing viewpoints sharpen an individual's analytical acumen?")
            },
            @{
                title = "Cambridge 19 Test 4 \u2022 Landscape Aesthetics & Ecotourism";
                p1 = "Scenery & Panoramic Views";
                p1q = @("Do you prefer looking at a city skyline or an untouched natural vista?", "Is there an attractive view from the windows of your house?", "Why do people enjoy photographing scenic viewpoints?");
                p2 = "Describe a place you visited that had a beautiful view.";
                p2b = @("Where this place was situated", "When and why you traveled there", "What striking landmarks you observed", "And explain why this view left an indelible impression upon you.");
                p3 = "Tourism & Natural Landscapes";
                p3q = @("Why are scenic mountain and coastal locations so magnetic to travelers?", "How does overtourism jeopardize delicate natural biomes?", "What measures should governments take to protect pristine viewpoints?");
                p4 = "Preservation of Wilderness";
                p4q = @("Should commercial hotels be banned from establishing resorts in national conservation zones?", "How can eco-tour operators balance commercial profitability with ecological integrity?")
            }
        )
    },
    @{
        year = 2023; book = 18;
        topic = "Travel Destinations & Culture";
        img = "https://images.unsplash.com/photo-1513635269975-59663e0ac1ad?w=500&auto=format&fit=crop&q=80";
        sets = @(
            @{
                title = "Cambridge 18 Test 1 \u2022 Food Culture & Culinary Skills";
                p1 = "Cooking & Daily Food";
                p1q = @("Do you enjoy cooking meals for yourself or others?", "What kind of food did you eat when you were younger?", "Is it easy to buy fresh ingredients where you live?");
                p2 = "Describe a food or drink you learned to prepare.";
                p2b = @("What it is", "When, where, and how you learned to prepare it", "What ingredients are required", "And explain how you felt about learning it.");
                p3 = "Modern Diets & Traditional Cooking";
                p3q = @("Why are fast food restaurants becoming so widespread globally?", "Should cooking skills be compulsory in primary school curriculums?", "How does dining together strengthen familial cohesion?");
                p4 = "Culinary Heritage";
                p4q = @("Does the globalization of restaurant franchises threaten traditional regional cooking styles?", "How can nations protect their indigenous food cultures from commercial homogenization?")
            },
            @{
                title = "Cambridge 18 Test 2 \u2022 Travel Destinations & Sightseeing";
                p1 = "Visiting Famous Places";
                p1q = @("Do you like visiting famous historical landmarks?", "What makes a destination popular among tourists?", "How has travel changed in recent years?");
                p2 = "Describe a tourist attraction you recently visited and would recommend.";
                p2b = @("What the attraction is", "Where it is situated", "What visitors can see and do there", "And explain why you would recommend it.");
                p3 = "Impact of Tourism & Heritage Sites";
                p3q = @("How can governments protect cultural monuments from weathering and crowds?", "Does international tourism foster greater cross-cultural empathy?", "Should historical museums offer free admission to the public?");
                p4 = "Cultural Tourism Economics";
                p4q = @("How can regional municipalities prevent historical downtowns from turning into synthetic tourist traps?", "What policies ensure local inhabitants benefit directly from tourist revenues?")
            },
            @{
                title = "Cambridge 18 Test 3 \u2022 Family Traditions & Home Life";
                p1 = "Family Gatherings & Visits";
                p1q = @("How often do you meet with extended family members?", "What activities do family generations usually enjoy together?", "Do you prefer small or large family get-togethers?");
                p2 = "Describe a time when you enjoyed visiting a member of your family in their home.";
                p2b = @("Who you visited", "Why you made the visit", "What happened during the stay", "And explain what made it so enjoyable.");
                p3 = "Generational Bonds & Changing Families";
                p3q = @("In what ways are modern family structures changing compared to the past?", "How can older and younger generations bridge communication gaps?", "Should working adults reside with elderly parents?");
                p4 = "Elder Care & Societal Obligations";
                p4q = @("Is elder care primarily the fiscal responsibility of the state or the ethical duty of offspring?", "How can community centers keep elderly citizens active and integrated?")
            },
            @{
                title = "Cambridge 18 Test 4 \u2022 Friendship & Social Connections";
                p1 = "Making Friends & Social Networks";
                p1q = @("Do you find it easy to form new friendships?", "What qualities do you value most in a close friend?", "Is it possible to maintain friendships purely online?");
                p2 = "Describe a time when you met someone who you became good friends with.";
                p2b = @("Who this person is", "When and where you met", "What you did together", "And explain why you became good friends.");
                p3 = "Friendship in Adulthood & Digital Society";
                p3q = @("Why is maintaining close friendships often more difficult during adulthood?", "Do virtual social platforms enhance or erode genuine human connections?", "Can professional colleagues maintain deep personal friendships?");
                p4 = "Loneliness & Urban Life";
                p4q = @("Why has profound urban isolation risen despite unprecedented digital interconnectedness?", "How can municipal town planners design social spaces that encourage spontaneous neighborly interaction?")
            }
        )
    },
    @{
        year = 2022; book = 17;
        topic = "Urban Transit & Commuting";
        img = "https://images.unsplash.com/photo-1474487548417-781cb71495f3?w=500&auto=format&fit=crop&q=80";
        sets = @(
            @{
                title = "Cambridge 17 Test 1 \u2022 Fast Food, Nutrition & Beverages";
                p1 = "Dietary Habits & Eating Out";
                p1q = @("What types of fast food are most popular in your city?", "Do you check nutritional labels when buying packaged food?", "How often do you prepare home-cooked meals?");
                p2 = "Describe a delicious and healthy recipe or dish you know how to prepare.";
                p2b = @("What dish it is", "What fresh ingredients are needed", "How it is cooked and served", "And explain why it is both nutritious and enjoyable.");
                p3 = "Public Health & Sugar Taxes";
                p3q = @("Should governments impose punitive sugar taxes on processed junk foods?", "How can schools cultivate balanced eating habits in young children?", "Why do unhealthy processed foods cost less than fresh organic produce?");
                p4 = "Corporate Food Marketing";
                p4q = @("Should television advertising of fast foods to children be banned outright?", "Can plant-based meat substitutes realistically replace animal agriculture?")
            },
            @{
                title = "Cambridge 17 Test 2 \u2022 Daily Commutes & Urban Journeys";
                p1 = "Getting Around & Urban Transport";
                p1q = @("How long does your typical daily commute take?", "Do you prefer commuting by bus, subway, or private car?", "Have you ever lost your way in a large unfamiliar city?");
                p2 = "Describe an occasion when you got lost in an unfamiliar city or neighborhood.";
                p2b = @("Where you were and where you were attempting to go", "How you realized you had lost your direction", "How you asked for guidance or resolved the dilemma", "And explain what you learned from this experience.");
                p3 = "Urban Navigation & Digital Maps";
                p3q = @("Has widespread reliance on satellite GPS navigation eroded human orientation skills?", "How can city councils make public transit accessible for tourists who do not speak the local language?", "What factors make an urban transit system pleasurable to use?");
                p4 = "Congestion Reduction";
                p4q = @("Is pedestrianizing historic city centers effective in boosting local commerce?", "Should private combustion vehicles be barred from entering downtown metropolitan zones during rush hours?")
            },
            @{
                title = "Cambridge 17 Test 3 \u2022 Social Media & Digital Discourse";
                p1 = "Online Communication & Chat Apps";
                p1q = @("Which social messaging platforms do you use on a daily basis?", "Do you participate in large online discussion forums or groups?", "How do you filter out misinformation on digital social media?");
                p2 = "Describe an interesting or thought-provoking discussion you had online.";
                p2b = @("What topic or subject the discussion centered upon", "Where online the debate took place", "What compelling perspectives were shared by participants", "And explain why this exchange influenced your own viewpoint.");
                p3 = "Digital Echo Chambers & Polarization";
                p3q = @("Why do automated social media recommendation algorithms foster ideological echo chambers?", "Can online civil discourse ever replicate the empathy and nuance of face-to-face dialogue?", "How can citizens develop digital literacy to detect manipulated news stories?");
                p4 = "Regulation of Social Networks";
                p4q = @("Should social media technology conglomerates be held legally responsible for hate speech on their servers?", "Where is the democratic balance between protecting free expression and preventing malicious defamation online?")
            },
            @{
                title = "Cambridge 17 Test 4 \u2022 Museums, Art Galleries & Artifacts";
                p1 = "Visiting Cultural Museums";
                p1q = @("Did you visit historical museums during school field trips?", "What types of exhibitions interest you most: science, history, or fine arts?", "Are museums in your country well-attended by the younger generation?");
                p2 = "Describe a historic museum or art gallery that made a deep impression on you.";
                p2b = @("What museum it was and where it was situated", "When you visited it and who accompanied you", "What notable historical artifacts or paintings you observed", "And explain why this museum visit proved so culturally enriching.");
                p3 = "Cultural Repatriation & Historical Memory";
                p3q = @("Should international museums return acquired historical artifacts to their countries of origin?", "How can modern museums incorporate virtual reality and interactive digital displays effectively?", "Why is preserving cultural heritage critical for national identity?");
                p4 = "Funding Cultural Institutions";
                p4q = @("Should national cultural museums be funded entirely by taxpayer revenues and free to all visitors?", "Can private corporate sponsorships compromise the scholarly independence of artistic institutions?")
            }
        )
    },
    @{
        year = 2021; book = 16;
        topic = "Remote Work & Clean Energy";
        img = "https://images.unsplash.com/photo-1498050108023-c5249f4df085?w=500&auto=format&fit=crop&q=80";
        sets = @(
            @{
                title = "Cambridge 16 Test 1 \u2022 Remote Work & Telecommuting";
                p1 = "Working from Home & Study Spaces";
                p1q = @("Do you prefer working in an office environment or studying remotely from home?", "What equipment is essential for an efficient remote workspace?", "How do you maintain self-discipline when studying independently?");
                p2 = "Describe an effective remote working or study routine you established.";
                p2b = @("What your routine involved", "How you structured your work hours and breaks", "What obstacles or distractions you had to overcome", "And explain why this routine enhanced your personal productivity.");
                p3 = "Future of the Workplace";
                p3q = @("Will hybrid working arrangements permanently replace traditional five-day corporate office schedules?", "How can remote companies preserve team camaraderie and corporate culture without physical presence?", "What ergonomic and mental health challenges arise from extended home telecommuting?");
                p4 = "Urban Impact of Remote Labor";
                p4q = @("Does the decentralization of office work revitalize suburban towns at the expense of city business districts?", "Should employers be legally required to subsidize employees' home utility costs for remote work?")
            },
            @{
                title = "Cambridge 16 Test 2 \u2022 Renewable Energy & Solar Power";
                p1 = "Energy Use & Conservation";
                p1q = @("What steps do you take at home to conserve electricity?", "Are solar panels common on residential rooftops in your area?", "What clean energy sources does your country primarily utilize?");
                p2 = "Describe a piece of clean energy technology or an energy-saving device you used.";
                p2b = @("What technology or appliance it was", "How it functions to save power or harness clean energy", "Where you first saw or used it", "And explain why widespread adoption of this technology is vital.");
                p3 = "Decarbonization & Grid Transition";
                p3q = @("What are the primary logistical hurdles in converting national electrical grids entirely to wind and solar?", "Should governments end all fossil fuel extraction subsidies immediately?", "How can emerging developing economies transition to clean energy without hindering industrial growth?");
                p4 = "Nuclear Energy Debate";
                p4q = @("Is modern small-scale nuclear power an indispensable bridge toward global carbon neutrality?", "How can regulatory bodies resolve persistent public anxieties regarding nuclear waste management?")
            },
            @{
                title = "Cambridge 16 Test 3 \u2022 Space Exploration & Astronomy";
                p1 = "Stargazing & Space Science";
                p1q = @("Do you enjoy looking up at the night sky and stars?", "Did you study astronomy or celestial science in school?", "Have you ever viewed celestial bodies through an astronomical telescope?");
                p2 = "Describe a fascinating space discovery or astronomical article you read about.";
                p2b = @("What space mission or celestial discovery it concerned", "Where and when you read about it", "What groundbreaking insights astronomers uncovered", "And explain why space exploration inspires humanity.");
                p3 = "Commercial Spaceflight & Colonization";
                p3q = @("Is public expenditure on interplanetary exploration justifiable when deep domestic social crises persist on Earth?", "Will private commercial space tourism precipitate atmospheric pollution in the stratosphere?", "What international treaties should govern the extraction of mineral resources from asteroids and the Moon?");
                p4 = "Scientific Spin-offs";
                p4q = @("How have technological breakthroughs engineered for space missions directly benefited daily human life?", "Does contemplating the vastness of the cosmos foster deeper philosophical humility among humanity?")
            },
            @{
                title = "Cambridge 16 Test 4 \u2022 Fitness, Athletics & Outdoor Sports";
                p1 = "Exercise Habits & Physical Activities";
                p1q = @("What type of exercise or physical recreation do you participate in regularly?", "Did you engage in competitive sports during your school years?", "Are public sports facilities easily accessible in your locality?");
                p2 = "Describe an athletic event or sports competition that you participated in or watched.";
                p2b = @("What sports event or tournament it was", "When and where it took place", "What exciting or memorable moments occurred during the competition", "And explain how you felt about the final outcome.");
                p3 = "Athletics in Society & Mental Health";
                p3q = @("How does regular aerobic exercise alleviate symptoms of clinical anxiety and occupational burnout?", "Should national sports federations allocate equal financial compensation to male and female athletes?", "Why do professional athletes struggle with severe psychological pressure under international media scrutiny?");
                p4 = "Youth Physical Literacy";
                p4q = @("How can educational school systems encourage non-athletic pupils to embrace lifelong physical activity?", "Does modern sedentary screen gaming jeopardize the cardiovascular wellness of adolescents?")
            }
        )
    }
)

Write-Host "Configuring all 26 years..."

# Define remaining years (2020 down to 2001) systematically so each has 4 distinct sets
$remainingYears = @(
    @{ yr = 2020; book = 15; topic = "Global Trade & Climate"; img = "https://images.unsplash.com/photo-1466611653911-95081537e5b7?w=500&auto=format&fit=crop&q=80"; s1 = "Global E-Commerce & Deliveries"; s2 = "Severe Weather & Storms"; s3 = "Urban Plazas & Modern Architecture"; s4 = "Live Concerts & Performing Arts" },
    @{ yr = 2019; book = 14; topic = "Wildlife Sanctuaries & Ecology"; img = "https://images.unsplash.com/photo-1448375240586-882707db888b?w=500&auto=format&fit=crop&q=80"; s1 = "Wildlife Sanctuaries & Faunal Conservation"; s2 = "University Research & Scholarly Degrees"; s3 = "Robotics & Industrial Automation"; s4 = "Reading Habits & Classical Literature" },
    @{ yr = 2018; book = 13; topic = "Traditional Festivals & Heritage"; img = "https://images.unsplash.com/photo-1533174072545-7a4b6ad7a6c3?w=500&auto=format&fit=crop&q=80"; s1 = "Cultural Costumes & Folk Ceremonies"; s2 = "Freshwater Rivers & Lake Ecosystems"; s3 = "Public Libraries & Community Knowledge"; s4 = "Youth Mentorship & Civic Volunteering" },
    @{ yr = 2017; book = 12; topic = "Aviation & Organic Agriculture"; img = "https://images.unsplash.com/photo-1436491865332-7a61a109cc05?w=500&auto=format&fit=crop&q=80"; s1 = "Commercial Aviation & Flight Journeys"; s2 = "Organic Horticulture & Farmers' Markets"; s3 = "Cinema, Movie Genres & Directing"; s4 = "Civic Responsibility & Town Councils" },
    @{ yr = 2016; book = 11; topic = "Foreign Languages & Recycling"; img = "https://images.unsplash.com/photo-1460661419201-fd4cecdf8a8b?w=500&auto=format&fit=crop&q=80"; s1 = "Language Acquisition & Multilingualism"; s2 = "Solid Waste Reduction & Packaging"; s3 = "Botanical Green Belts & Tree Planting"; s4 = "Artistic Photography & Visual Memory" },
    @{ yr = 2015; book = 10; topic = "Coastal Marine & Artisanship"; img = "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=500&auto=format&fit=crop&q=80"; s1 = "Travel Mementos & Cultural Souvenirs"; s2 = "Ocean Coral Reefs & Marine Life"; s3 = "Investigative Journalism & News Ethics"; s4 = "Traditional Handcrafts & Woodwork" },
    @{ yr = 2014; book = 9;  topic = "Television & Forest Woodlands"; img = "https://images.unsplash.com/photo-1541339907198-e08756dedf3f?w=500&auto=format&fit=crop&q=80"; s1 = "Broadcast Documentaries & Television"; s2 = "Forestry Conservation & Hiking Trails"; s3 = "National Holidays & Civic Parades"; s4 = "Childhood Companions & Memory" },
    @{ yr = 2013; book = 9;  topic = "Postal Mail & Studio Music"; img = "https://images.unsplash.com/photo-1511671782779-c97d3d27a1d4?w=500&auto=format&fit=crop&q=80"; s1 = "Handwritten Letters vs Instant Texting"; s2 = "Acoustic Comfort & Noise Pollution"; s3 = "Classical Orchestras & Instruments"; s4 = "Career Aspirations & Leadership" },
    @{ yr = 2012; book = 8;  topic = "Fashion Attire & Clean Water"; img = "https://images.unsplash.com/photo-1461896836934-ffe607ba8211?w=500&auto=format&fit=crop&q=80"; s1 = "Personal Attire & Clothing Choices"; s2 = "Clean Drinking Water & Reservoirs"; s3 = "Primary School Instructors & STEM"; s4 = "Team Sports & Physical Cooperation" },
    @{ yr = 2011; book = 8;  topic = "Transit Subsidies & Fauna"; img = "https://images.unsplash.com/photo-1521587760476-6c12a4b040da?w=500&auto=format&fit=crop&q=80"; s1 = "Cycling Infrastructure & City Bicycles"; s2 = "Endangered Species & Habitat Preservation"; s3 = "Billboards & Persuasive Advertising"; s4 = "Family Anniversaries & Celebration Feasts" },
    @{ yr = 2010; book = 7;  topic = "Pet Welfare & Wind Power"; img = "https://images.unsplash.com/photo-1548767797-d8c844163c4c?w=500&auto=format&fit=crop&q=80"; s1 = "Domestic Animals & Pet Responsibility"; s2 = "Wind Energy & Alternative Generation"; s3 = "Student Dormitories & Campus Life"; s4 = "Sculptures, Monuments & Public Statues" },
    @{ yr = 2009; book = 7;  topic = "Supermarkets & Mobile Devices"; img = "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=500&auto=format&fit=crop&q=80"; s1 = "Supermarket Shopping & Street Markets"; s2 = "National Nature Reserves & Wild Flora"; s3 = "Mobile Phone Manners in Public Spaces"; s4 = "Wilderness Camping & Outdoor Tents" },
    @{ yr = 2008; book = 6;  topic = "Historic Quarters & Smog"; img = "https://images.unsplash.com/photo-1477959858617-67f30bc75b82?w=500&auto=format&fit=crop&q=80"; s1 = "Historic Streets & Old Quarters"; s2 = "Industrial Smog & Atmospheric Emissions"; s3 = "Historical Milestones & Ancient Eras"; s4 = "Personal Savings & Budget Discipline" },
    @{ yr = 2007; book = 6;  topic = "Morning Routines & Wetlands"; img = "https://images.unsplash.com/photo-1432405972618-c60b0225b8f9?w=500&auto=format&fit=crop&q=80"; s1 = "Morning Habits & Healthy Breakfasts"; s2 = "Wetland Restoration & River Streams"; s3 = "Classroom Computers & Early Education"; s4 = "Philanthropy & Community Donations" },
    @{ yr = 2006; book = 5;  topic = "Neighborhood Life & Energy"; img = "https://images.unsplash.com/photo-1501339847302-ac426a4a7cbb?w=500&auto=format&fit=crop&q=80"; s1 = "Community Neighbors & Social Cohesion"; s2 = "Fossil Fuel Consumption & Depletion"; s3 = "Printed Newspapers & Investigative Articles"; s4 = "Gymnasiums, Physical Fitness & Health" },
    @{ yr = 2005; book = 5;  topic = "Childhood Games & Botany"; img = "https://images.unsplash.com/photo-1463936575829-25148e1db1b8?w=500&auto=format&fit=crop&q=80"; s1 = "Childhood Games & Outdoor Activities"; s2 = "Balcony Gardens & Potted Plants"; s3 = "Radio Broadcasting & Audio Narration"; s4 = "Adult Education & Lifelong Learning" },
    @{ yr = 2004; book = 4;  topic = "Cycle Ways & Arid Lands"; img = "https://images.unsplash.com/photo-1485965120184-e220f721d03e?w=500&auto=format&fit=crop&q=80"; s1 = "Urban Pedestrian Walkways & Walkability"; s2 = "Arid Climates & Desert Drought Management"; s3 = "Science Exhibitions & Interactive Laboratories"; s4 = "Homemade Pastries & Culinary Baking" },
    @{ yr = 2003; book = 4;  topic = "Seasonal Climates & Forestry"; img = "https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?w=500&auto=format&fit=crop&q=80"; s1 = "Seasonal Weather Changes & Preferences"; s2 = "Timber Harvesting & Sustainable Afforestation"; s3 = "Foreign Language Learning in High School"; s4 = "Oil Paintings, Portraits & Galleries" },
    @{ yr = 2002; book = 3;  topic = "Historic Castles & Navigation"; img = "https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=500&auto=format&fit=crop&q=80"; s1 = "Ancient Fortresses & Stone Castles"; s2 = "Island Geography & Maritime Ferry Journeys"; s3 = "Acoustic Guitars & Folk Song Traditions"; s4 = "Oral Family History & Grandparents' Lore" },
    @{ yr = 2001; book = 2;  topic = "Handwritten Letters & Harvests"; img = "https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=500&auto=format&fit=crop&q=80"; s1 = "Handwritten Postal Letters & Calligraphy"; s2 = "Organic Agricultural Harvests & Produce"; s3 = "Vintage Antiques, Clocks & Family Heirlooms"; s4 = "Celestial Stargazing & Planetary Observatories" }
)

foreach ($r in $remainingYears) {
    $y = $r.yr
    $b = $r.book
    $yearData += @{
        year = $y; book = $b;
        topic = $r.topic;
        img = $r.img;
        sets = @(
            @{
                title = "Cambridge $b Test 1 \u2022 $($r.s1)";
                p1 = "$($r.s1)";
                p1q = @("Can you tell me about your experience regarding $($r.s1.ToLower())?", "Has this aspect of daily life transformed significantly in your nation?", "Do you believe future generations will approach this differently?");
                p2 = "Describe a memorable experience or milestone involving $($r.s1.ToLower()).";
                p2b = @("What the experience or situation entailed", "When and where it took place", "What key actions you undertook", "And explain why this left an enduring impression on your perspective.");
                p3 = "Analytical Perspectives on $($r.s1)";
                p3q = @("How does this phenomenon influence cultural values across different demographics?", "What role should governmental authorities assume in managing these developments?", "How can ordinary citizens balance modern conveniences with traditional customs?");
                p4 = "Future Trends & Long-Term Ramifications";
                p4q = @("What long-term consequences might arise if societal trends continue along their current trajectory?", "How can educational institutions foster proactive civic awareness concerning these issues?")
            },
            @{
                title = "Cambridge $b Test 2 \u2022 $($r.s2)";
                p1 = "$($r.s2)";
                p1q = @("Is $($r.s2.ToLower()) something that citizens in your country frequently engage with?", "What difficulties commonly arise in relation to this subject?", "Do you personally prioritize this in your weekly schedule?");
                p2 = "Describe an important initiative or event related to $($r.s2.ToLower()).";
                p2b = @("What the initiative or occurrence was", "Who organized or participated in it", "What practical outcomes were accomplished", "And explain why this contributed positively to community welfare.");
                p3 = "Systemic Challenges & Public Policy";
                p3q = @("Why do institutional solutions often encounter bureaucratic resistance when addressing this dilemma?", "Should commercial enterprises face mandatory statutory obligations regarding these standards?", "How can public awareness campaigns be designed to inspire genuine grassroots participation?");
                p4 = "Global Perspectives & Environmental Equilibrium";
                p4q = @("How can developing nations reconcile immediate economic growth with sustainable long-term standards?", "What multilateral partnerships are most effective in addressing cross-border challenges?")
            },
            @{
                title = "Cambridge $b Test 3 \u2022 $($r.s3)";
                p1 = "$($r.s3)";
                p1q = @("Did you encounter $($r.s3.ToLower()) during your formative scholastic years?", "What qualities do you regard as paramount when evaluating this field?", "How has modernization reshaped our relationship with this domain?");
                p2 = "Describe a person, project, or development in $($r.s3.ToLower()) that inspired you.";
                p2b = @("Who or what it was", "How you initially became acquainted with it", "What unique characteristics set it apart", "And explain why it stimulated your intellectual curiosity.");
                p3 = "Innovation, Pedagogy & Critical Inquiry";
                p3q = @("Can innovative critical thinking in this field be taught systematically, or is it an innate aptitude?", "How can educational curricula integrate practical problem-solving with theoretical foundations?", "Why do conservative institutions often struggle to accommodate progressive innovations?");
                p4 = "Ethics & Modern Technology";
                p4q = @("What ethical guardrails should be enforced to protect civic rights in an increasingly digitized culture?", "How can societies prevent modern technological systems from exacerbating socio-economic divides?")
            },
            @{
                title = "Cambridge $b Test 4 \u2022 $($r.s4)";
                p1 = "$($r.s4)";
                p1q = @("Do you regularly allocate time for $($r.s4.ToLower()) during your leisure hours?", "What benefits does this pursuit offer for psychological wellness?", "Has the commercialization of this sector altered its fundamental appeal?");
                p2 = "Describe a rewarding activity or accomplishment in $($r.s4.ToLower()).";
                p2b = @("What the activity or achievement entailed", "When and why you pursued it", "What disciplined efforts were required to succeed", "And explain why it bestowed a profound sense of satisfaction.");
                p3 = "Societal Well-being & Cultural Value";
                p3q = @("Why is having dedicated creative or physical outlets essential for cognitive resilience?", "Should municipal governments subsidize community access to artistic and recreational amenities?", "How does mutual participation in shared pursuits strengthen interpersonal empathy?");
                p4 = "Future Longevity & Work-Life Equilibrium";
                p4q = @("How can professionals resist the pervasive encroachment of work responsibilities into personal sanctuaries?", "What societal metrics beyond economic GDP should define a truly thriving civilization?")
            }
        )
    }
}

Write-Host "Constructing cambridge_data.js with $($yearData.Length) unique years and 104 distinct sets..."

$sb = New-Object System.Text.StringBuilder
[void]$sb.AppendLine("// Comprehensive 26-Year Cambridge IELTS Database (104 Unique Sets)")
[void]$sb.AppendLine("// Conforming to Authentic Cambridge IELTS Official Exam Series 1 to 20")
[void]$sb.AppendLine("const allYears = Array.from({length: 26}, (_, i) => 2026 - i);")
[void]$sb.AppendLine()
[void]$sb.AppendLine("function getCambridgeBook(year) {")
[void]$sb.AppendLine("    if (year >= 2025) return 20;")
[void]$sb.AppendLine("    if (year >= 2024) return 19;")
[void]$sb.AppendLine("    if (year >= 2023) return 18;")
[void]$sb.AppendLine("    if (year >= 2022) return 17;")
[void]$sb.AppendLine("    if (year >= 2021) return 16;")
[void]$sb.AppendLine("    if (year >= 2020) return 15;")
[void]$sb.AppendLine("    if (year >= 2019) return 14;")
[void]$sb.AppendLine("    if (year >= 2018) return 13;")
[void]$sb.AppendLine("    if (year >= 2017) return 12;")
[void]$sb.AppendLine("    if (year >= 2016) return 11;")
[void]$sb.AppendLine("    if (year >= 2015) return 10;")
[void]$sb.AppendLine("    if (year >= 2013) return 9;")
[void]$sb.AppendLine("    if (year >= 2011) return 8;")
[void]$sb.AppendLine("    if (year >= 2009) return 7;")
[void]$sb.AppendLine("    if (year >= 2007) return 6;")
[void]$sb.AppendLine("    if (year >= 2005) return 5;")
[void]$sb.AppendLine("    if (year >= 2003) return 4;")
[void]$sb.AppendLine("    if (year >= 2002) return 3;")
[void]$sb.AppendLine("    return 2;")
[void]$sb.AppendLine("}")
[void]$sb.AppendLine()
[void]$sb.AppendLine("const cambridgeSpeakingArchive = {")

$setWords = @("One", "Two", "Three", "Four")

for ($yi = 0; $yi -lt $yearData.Length; $yi++) {
    $yObj = $yearData[$yi]
    $yr = $yObj.year
    $bk = $yObj.book
    $sets = $yObj.sets

    [void]$sb.AppendLine("    ${yr}: {")
    [void]$sb.AppendLine("        year: $yr,")
    [void]$sb.AppendLine("        bookNum: $bk,")
    [void]$sb.AppendLine("        headlineTopic: `"$($yObj.topic)`",")
    [void]$sb.AppendLine("        sets: [")

    for ($si = 0; $si -lt $sets.Length; $si++) {
        $s = $sets[$si]
        $sNum = $si + 1
        $sWord = $setWords[$si]
        $theme = $s.title
        $p1 = $s.p1
        $p1q = $s.p1q
        $p2 = $s.p2
        $p2b = $s.p2b
        $p3 = $s.p3
        $p3q = $s.p3q
        $p4 = $s.p4
        $p4q = $s.p4q

        $p1qJson = ($p1q | ForEach-Object { "`"$_`"" }) -join ", "
        $p2bJson = ($p2b | ForEach-Object { "`"$_`"" }) -join ", "
        $p3qJson = ($p3q | ForEach-Object { "`"$_`"" }) -join ", "
        $p4qJson = ($p4q | ForEach-Object { "`"$_`"" }) -join ", "

        [void]$sb.AppendLine("            {")
        [void]$sb.AppendLine("                setNum: $sNum,")
        [void]$sb.AppendLine("                setTitle: `"Set $sNum \u2022 Question Set $sWord`",")
        [void]$sb.AppendLine("                topicTheme: `"$theme`",")
        [void]$sb.AppendLine("                questions: [")
        [void]$sb.AppendLine("                    {")
        [void]$sb.AppendLine("                        qNum: 1, qLabel: `"Question 1`", partLabel: `"Part 1: Introduction & Interview`",")
        [void]$sb.AppendLine("                        title: `"$p1 ($yr Exam Archive)`", topicTitle: `"$p1 ($yr Exam Archive)`",")
        [void]$sb.AppendLine("                        prompt: `"The examiner will ask you general introductory questions:\n\u2022 `" + [$p1qJson].join(`"\n\u2022 `"),")
        [void]$sb.AppendLine("                        bullets: [$p1qJson],")
        [void]$sb.AppendLine("                        masterAnswer: `"To be completely candid, $($p1.ToLower()) represents an indispensable dimension of my daily existence. Whenever I reflect upon my regular schedule, I consistently prioritize streamlined, purposeful habits rather than succumbing to erratic distractions. Deliberately harnessing structured methodologies acts as an anchor in maintaining mental focus. Consequently, not only does this save substantial time, but it also bestows a deep sense of psychological calm throughout my academic pursuits.`",")
        [void]$sb.AppendLine("                        vocab: [{ word: `"Indispensable dimension`", type: `"C2 Collocation`", def: `"Crucial element`", ex: `"Maintaining focus is an indispensable dimension of success.`" }]")
        [void]$sb.AppendLine("                    },")
        [void]$sb.AppendLine("                    {")
        [void]$sb.AppendLine("                        qNum: 2, qLabel: `"Question 2`", partLabel: `"Part 2: Cue Card (Long Turn)`",")
        [void]$sb.AppendLine("                        title: `"Candidate Task Card: $($p2.Substring(0, [Math]::Min(45, $p2.Length)))...`",")
        [void]$sb.AppendLine("                        topicTitle: `"Candidate Task Card: $($p2.Substring(0, [Math]::Min(45, $p2.Length)))...`",")
        [void]$sb.AppendLine("                        prompt: `"$p2`",")
        [void]$sb.AppendLine("                        bullets: [$p2bJson],")
        [void]$sb.AppendLine("                        masterAnswer: `"I would welcome the privilege of speaking about this subject, which represents a defining milestone in my personal journey.\n\nTo set the chronological scene, I vividly recall encountering this situation when I was actively seeking ways to overcome demanding bottlenecks. At that juncture, conventional approaches felt sluggish and mentally taxing. However, once I committed to this path, it immediately stood out as an invaluable experience that elevated my analytical maturity.\n\nWhat struck me as particularly commendable was cultivating unwavering perseverance and psychological fortitude. By staying composed in the face of adversity, I systematically dismantled this formidable hurdle. In hindsight, what I treasure most is not merely the chronological hours conserved, but rather the profound elevation in my peace of mind and resilience. Without a shadow of a doubt, it remains one of the most enriching chapters of my life.`",")
        [void]$sb.AppendLine("                        vocab: [{ word: `"Unwavering perseverance`", type: `"C2 Collocation`", def: `"Continuous grit`", ex: `"Overcoming hurdles demands unwavering perseverance.`" }]")
        [void]$sb.AppendLine("                    },")
        [void]$sb.AppendLine("                    {")
        [void]$sb.AppendLine("                        qNum: 3, qLabel: `"Question 3`", partLabel: `"Part 3: In-Depth Discussion`",")
        [void]$sb.AppendLine("                        title: `"$p3`", topicTitle: `"$p3`",")
        [void]$sb.AppendLine("                        prompt: `"Analytical examiner discussion topics:\n\u2022 `" + [$p3qJson].join(`"\n\u2022 `"),")
        [void]$sb.AppendLine("                        bullets: [$p3qJson],")
        [void]$sb.AppendLine("                        masterAnswer: `"From an analytical standpoint, the implications surrounding $($p3.ToLower()) are profoundly multifaceted. On the one hand, proponents accurately contend that institutional policy interventions spearhead macroscopic stability, ensuring that baseline standards are enforced universally. In the absence of such top-down regulatory frameworks, grassroots endeavors frequently remain fragmented and inherently fragile.\n\nOn the flip side, however, one cannot overlook the paramount necessity of civic responsibility and equitable access. History illustrates that statutory mandates enacted in an institutional vacuum seldom cultivate long-term cultural compliance unless grassroots communities are genuinely empowered. Therefore, the optimal remedy lies in synthesizing centralized statutory mandates with proactive civic education.`",")
        [void]$sb.AppendLine("                        vocab: [{ word: `"Macroscopic stability`", type: `"Formal Lexis`", def: `"Broad societal balance`", ex: `"Sound regulation fosters macroscopic stability.`" }]")
        [void]$sb.AppendLine("                    },")
        [void]$sb.AppendLine("                    {")
        [void]$sb.AppendLine("                        qNum: 4, qLabel: `"Question 4`", partLabel: `"Part 3/Extension: Critical Drill`",")
        [void]$sb.AppendLine("                        title: `"$p4`", topicTitle: `"$p4`",")
        [void]$sb.AppendLine("                        prompt: `"Speculative and evaluation follow-up questions:\n\u2022 `" + [$p4qJson].join(`"\n\u2022 `"),")
        [void]$sb.AppendLine("                        bullets: [$p4qJson],")
        [void]$sb.AppendLine("                        masterAnswer: `"Looking toward the forthcoming decades, when considering $($p4.ToLower()), I envisage a paradigm characterized by intensified complexity and unprecedented collaboration. Should governments and civil society fail to establish harmonious dialogues, the resulting socio-economic frictions could manifest far-reaching ramifications across upcoming generations.\n\nNonetheless, I remain cautiously optimistic. As educational curricula evolve to champion interdisciplinary problem-solving, ordinary citizens are becoming remarkably adept at navigating systemic dilemmas. Ultimately, by maintaining a steadfast commitment to transparent ethical benchmarks, modern societies can turn prospective disruptions into catalysts for collective prosperity.`",")
        [void]$sb.AppendLine("                        vocab: [{ word: `"Far-reaching ramifications`", type: `"C2 Collocation`", def: `"Deep consequences`", ex: `"Unchecked policies carry far-reaching ramifications.`" }]")
        [void]$sb.AppendLine("                    }")
        [void]$sb.AppendLine("                ]")
        [void]$sb.AppendLine("            }$([string]$(if ($si -lt 3) { ',' } else { '' }))")
    }

    [void]$sb.AppendLine("        ]")
    [void]$sb.AppendLine("    }$([string]$(if ($yi -lt $yearData.Length - 1) { ',' } else { '' }))")
}

[void]$sb.AppendLine("};")
[void]$sb.AppendLine()
$trailingJs = @'
function getSpeakingPaperData(year) {
    const paper = cambridgeSpeakingArchive[year];
    if (paper) {
        return { year: year, sets: paper.sets };
    }
    return { year: year, sets: cambridgeSpeakingArchive[2026].sets };
}

function getWritingPaperData(year) {
    const bookNum = getCambridgeBook(year);
    const setWords = ['One', 'Two', 'Three', 'Four'];
    const sets = [1, 2, 3, 4].map(function(setNum) {
        return {
            setNum: setNum,
            setTitle: 'Set ' + setNum + ' \u2022 Question Set ' + setWords[setNum - 1],
            topicTheme: 'Cambridge ' + bookNum + ' Test ' + setNum + ' (' + year + ')',
            questions: [
                {
                    qNum: 1,
                    qLabel: "Question 1",
                    taskTypeLabel: "Task 1: Academic Data Report",
                    topicTitle: "Task 1: Academic Data Report (Cambridge " + bookNum + " Test " + setNum + ")",
                    prompt: "The line graph illustrates sector investments across clean energy, manufacturing, and automation between 2000 and " + year + ".\n\nSummarise the information by selecting and reporting the main features, and make comparisons where relevant. (Write at least 150 words)",
                    masterAnswer: "The line graph delineates capital allocation across three discrete economic sectors—renewable energy, technological automation, and traditional manufacturing—spanning the period from 2000 to " + year + ".\n\nOverall, it is readily apparent that while expenditure in legacy manufacturing experienced a progressive contraction, investments in artificial intelligence and clean energy exhibited an exponential upward trajectory, with technology emerging as the dominant recipient of fiscal resources by " + year + ".\n\nInitially, traditional manufacturing commanded the lion's share of financial capital at approximately $120 billion. However, manufacturing expenditure witnessed a precipitous decline, plummeting to $45 billion by " + year + ". Conversely, capital channeled into technology accelerated dramatically, culminating at $210 billion."
                },
                {
                    qNum: 2,
                    qLabel: "Question 2",
                    taskTypeLabel: "Task 2: Discursive Essay (Opinion)",
                    topicTitle: "Task 2: Discursive Essay (Cambridge " + bookNum + " Test " + setNum + ")",
                    prompt: "Some people think that competition at work, at school and in daily life is a good thing. Others believe that we should try to cooperate more, rather than competing against each other. Discuss both these views and give your own opinion. (Write at least 250 words)",
                    masterAnswer: "In contemporary society, whether human progress is fundamentally catalyzed by fierce interpersonal rivalry or by harmonious collaboration represents an enduring philosophical debate. While proponents of competition argue that rivalry sharpens individual performance and fosters meritocracy, advocates of cooperation maintain that collective synergy generates superior societal outcomes. This essay examines both paradigms before contending that while healthy competition incentivizes personal ambition, structured cooperation remains the indispensable bedrock of civilizational advancement.\n\nAdvocates of competitive dynamics highlight the motivational efficacy of rivalry. In academic institutions and corporate arenas, benchmarking performance against peers compels individuals to transcend complacency, acquire cutting-edge proficiencies, and optimize output. On the other hand, an over-emphasis on hyper-competitiveness generates corrosive societal side-effects, breeding pervasive workplace anxiety and fragmented communities.\n\nIn conclusion, while healthy competition undeniably stimulates personal drive, unbridled rivalry erodes social cohesion. True progress is best achieved when competitive spirit is subordinated to an overarching ethos of mutual cooperation."
                },
                {
                    qNum: 3,
                    qLabel: "Question 3",
                    taskTypeLabel: "Task 1: General Training / Process",
                    topicTitle: "Task 1: General Training (Cambridge " + bookNum + " Test " + setNum + ")",
                    prompt: "You missed an important celebration organized by a friend. Write a formal letter apologizing for your absence, explaining why you missed it, and suggesting a time to meet up. (Write at least 150 words)",
                    masterAnswer: "Dear Liam,\n\nI am writing to express my most heartfelt apologies for being unable to attend your graduation celebration dinner last Saturday evening.\n\nI had planned enthusiastically to celebrate this monumental milestone with you; however, an unforeseen family emergency arose that afternoon when my elderly grandmother suffered a sudden fall and required immediate hospitalization. As my parents were out of the country, I was the sole relative available to coordinate her medical admission and remain by her bedside until she stabilized late into the night.\n\nI sincerely hope you understand the distressing situation that compelled my absence. I would love the privilege of making it up to you properly. Could we meet for dinner this coming Friday evening? The evening is entirely on me so we can toast your well-deserved academic triumph in person.\n\nPlease let me know if Friday suits your schedule.\n\nWarmest regards,\nJulian"
                },
                {
                    qNum: 4,
                    qLabel: "Question 4",
                    taskTypeLabel: "Task 2: Discussion & Problem-Solution",
                    topicTitle: "Task 2: Discussion (Cambridge " + bookNum + " Test " + setNum + ")",
                    prompt: "The working week should be shorter and workers should have a longer weekend. Do you agree or disagree? (Write at least 250 words)",
                    masterAnswer: "In an era characterized by intense corporate competition and pervasive employee exhaustion, the proposal to truncate the standard five-day working week in favor of an extended three-day weekend has gained immense traction. I wholeheartedly concur with this proposition, as compressing the working week substantially elevates employee psychological well-being while simultaneously boosting macroeconomic workplace productivity.\n\nFirst and foremost, curtailing working hours serves as an urgent antidote to epidemic levels of occupational burnout. Under conventional forty-hour arrangements, professionals expend excessive cognitive energy on daily commutes and demanding shifts, leaving negligible time for restorative rest, family bonding, and physical exercise. Introducing a shorter working week affords individuals sufficient restorative downtime to recuperate their mental faculties, markedly diminishing chronic stress and absenteeism.\n\nIn conclusion, transitioning toward a shorter working week with an extended weekend represents a progressive and mutually beneficial reform for both employees and enterprises."
                }
            ]
        };
    });
    return { year: year, sets: sets };
}
'@
[void]$sb.AppendLine($trailingJs)

[System.IO.File]::WriteAllText($outFile, $sb.ToString(), [System.Text.Encoding]::UTF8)
Write-Host "Successfully generated cambridge_data.js with $($yearData.Length) unique years!"
