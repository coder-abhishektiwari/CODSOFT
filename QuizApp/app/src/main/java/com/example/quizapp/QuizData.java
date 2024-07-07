package com.example.quizapp;

public class QuizData {
    public static String[][][] questions = {
            {
                    {"Question 1: Though they sound happy, what animal's \"laugh\" is a reaction to being threatened?", "A. ox", "B. hyna", "C. baboon", "D. woodpecker"},
                    {"Question 2: Capable of exceeding 186 miles per hour, what is the fastest creature in the animal kingdom?", "A. peregrine falcon", "B. cheetah", "C. black marlin", "D. horsefly"},
                    {"Question 3: Known for its intelligence, which dog bread has been found capable of understanding more than a thousand words?", "A. french Bulldog", "B. dachshund", "C. border collie", "D. cocker spaniel"},
                    {"Question 4: Which animal species can live in extremes of both heat and cold from -20℉ to 120℉? ", "A. bactrian camel", "B. polar bear", "C. emperor penguin", "D. chuckwalla iguanas"},
                    {"Question 5: The tiniest animal with a backbone is a what?", "A. fish", "B. frog", "C. lizard", "D. bird"},
                    {"Question 6: Growing up to 59 feet (18 meters) long, which is the world's largest living fish?", "A. sailfish", "B. marlin", "C. manta ray", "D. whale shark"},
                    {"Question 7: Which of these \"fish\" is actually a fish?","A. swordfish", "B. crayfish", "C. starfish", "D. jellyfish"},
                    {"Question 8: The largest \"town\" home to what animal was an underground colony measuring 25,000 square miles, found in Texas?", "A. beaver", "B. capybara", "C. meerkat", "D. prairie dog"},
                    {"Question 9: An individual animal of which type was found to be at least 272 years old, suggesting that its type includes the world's longest-living vertebrate?", "A. greenland shark", "B. indian elephant", "C. japanese wagyu cattle", "D. galapagos tortoise"},
                    {"Question 10: What gives flamingos their ping color?", "A. reaction to sunlight", "B. eating shrimp", "C. dominant genes", "D. mud captured in feathers"}
            },
            {
                    {"Question 1: Though it originated in China, which fruit was named for Persia, where Europeans first encountered it?", "A. plantain", "B. papaya", "C. peach", "D. pineapple"},
                    {"Question 2: Where would you find empanadas being made?", "A. pakistan", "B. japan", "C. spain", "D. tanzania"},
                    {"Question 3: The durian fruit of Southeast Asia is banned in many places for what reason?", "A. its pungent smell", "B. it's too dangerous to harvest", "C. it's considered sacred", "D. it attracts animals"},
                    {"Question 4: In what country might you sit down to a smorgasbord?", "A. switzerland", "B. swaziland", "C. sweden", "D. south africa"},
                    {"Question 5: A delicacy in Scotland, haggis is served inside what animal part?", "A. kangaroo's puch", "B. camel's hump", "C. sheep's stomach", "D. alligator's tail"},
                    {"Question 6: The name Wiener schnitzel uses the German word for which for nation's capital city?", "A. Russia", "B. Denmark", "C. the Netherlands", "D. Austria"},
                    {"Question 7: Which of these foods is named for the clay oven in which it is baked?", "A. falafel", "B. couscous", "C. tandoori chicken", "D. lobster thermidor"},
                    {"Question 8: The Peruvian fish delicacy cerviche is cooked in what unusual way?", "A. using magnified sunlight", "B. without heat", "C. over moltan lava", "D. burying it in sand"},
                    {"Question 9: About one in five South Koreans has a separate refrigerator to store and ferment what food?", "A. kimchi", "B. injera", "C. sashimi", "D. pho"},
                    {"Question 10: Which of these foods was created in the 1930s to help establish a national identity?", "A. scotch egg", "B. french toast", "C. pad thai", "D. danish pastry"},
            },
            {
                    {"Question 1: Why did the scarecrow win an award?", "A. He was out-standing in his field", "B. He scared the most crows", "C. He had a straw-vagant costume", "D. He could tell corn-y jokes"},
                    {"Question 2: Why don't skeletons fight each other?", "A. They are spineless", "B. They don't have the guts", "C. They break too easily", "D. They just rattle on"},
                    {"Question 3: Why did the bicycle fall over?", "A. It was tired", "B. It lost its balance", "C. It got a flat tire", "D. It was two-tired"},
                    {"Question 4: Why was the math book sad?", "A. It had too many problems", "B. It was over-used", "C. It lost its pages", "D. It was outdated"},
                    {"Question 5: Why did the golfer bring an extra pair of pants?", "A. In case he got a hole in one", "B. For a costume change", "C. He liked variety", "D. To stay warm"},
                    {"Question 6: Why don't crabs give to charity?", "A. Because they are shellfish", "B. They have no pockets", "C. They can't write checks", "D. They always claw back their donations"},
                    {"Question 7: Why did the coffee file a police report?", "A. It was mugged", "B. It was spilled", "C. It was brewed over", "D. It was roasted"},
                    {"Question 8: Why did the computer go to the doctor?", "A. It had a virus", "B. It had a hard drive", "C. It needed a reboot", "D. It had a bad byte"},
                    {"Question 9: What do you call a fish wearing a crown?", "A. A royal fish", "B. A crowned salmon", "C. King Neptune", "D. A kingfish"},
                    {"Question 10: Why don't some couples go to the gym?", "A. Because they don't want to work out", "B. Because they are two-tired", "C. Because they want to stay at home", "D. Because some relationships don't work out"},
                    {"Question 11: Why did the tomato turn red?", "A. Because it saw the salad dressing", "B. Because it was blushing", "C. Because it was ripe", "D. Because it was in love"},
                    {"Question 12: Why did the scarecrow become a successful neurosurgeon?", "A. He had a lot of brains", "B. He was outstanding in his field", "C. He had straw-gic skills", "D. He stitched his patients well"}
            }
    };

    public static int[][] correctAnswers = {
            {1, 0, 2, 0, 1, 3, 0, 3, 0, 1}, // Correct answers for animal quiz ["B. hyna", "A. peregrine falcon", "C. border collie", "A. bactrian camel", "B. frog", "D. whale shark", "A. swordfish", "D. prairie dog", "A. greenland shark", "B. eating shrimp"]
            {2, 2, 0, 2, 2, 3, 2, 1, 0, 2}, // Correct answers for food quiz ["C. peach", "C. spain", "A. its pungent smell", "C. sweden", "C. sheep's stomach", ". DAustria", "C. tandoori chicken", "B. without heat", "A. kimchi", "C. pad thai"]
            {0, 1, 3, 0, 0, 0, 0, 0, 3, 3, 0, 0} // Correct answers for funny quiz ["A. He was out-standing in his field", "B. They don't have the guts", "B. It lost its balance", "A. It had too many problems", "A. In case he got a hole in one", "A. Because they are shellfish", "A. It was mugged", "A. It had a virus", "D. A kingfish", "D. Because some relationships don't work out"]

    };
}
