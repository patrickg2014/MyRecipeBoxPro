package com.smarttechnow.patrick;

/**
 * This class holds the default recipes.
 * @author Patrick
 *
 */
public class Recipes{

	
	String recipes[] = {
			"Sweet Potato Pie", 
			"Pineapple Upside Down Cake", 
			"Watergate Salad",
			"100-Year-Old Oatmeal Cookies",
			"Salsa",
			"Fried Shrimp",
			"Texas-Style Chili"
			};
	String directions[] = {
			"1. Boil 5-6 yams. \n 2. Peel the yams and place in a bowl with 3 sticks of butter, tablespoon of nutmeg and 1 teaspoon of cinnamon mix. \n Mix using a mixer and slowly add white sugar to desired taste (1-6 cups).  \n 5. Add 2 tablespoons of vanilla. \n  6. Add 1 tablespoon of lemon flavor. \n 6. Add 2 tablespoons of baking powder. \n 7. Add ½ cup of flour. \n 8. Add about ¼-½ cup of milk. \n 9. Mix in 4 eggs. \n 10.Pour batter into shell and bake at 375 for 30 mins.",
			"Ingredients \n 1 small jar of cherry halves \n 1 box yellow cake mix \n 1 lbs bag of brown sugar \n 1 can sliced pineapple \n 1 stack of butter \n 1 cup of flour \n 2 eggs \n 1. Preheat oven/bake on high rack. \n 2. Follow the instructions of the yellow cake mix on the box. \n 3. Butter pan, add ½ cup of brown sugar. \n 4. Arrange pineapple and put cherry halves in center of pineapple and add cake batter. \n 5. Bake until done(unsually box direction length). \n 6. Put brown sugar in sauce pan. Heat and add enough pineapple juice to make a syrup. \n 7. Pour over cake and let cool.", 
			"Ingredients \n 2 pkgs pistachio pudding \n 2 lg cans of crushed pineapple w/juice \n 1 lg tub cool whip \n 1 cup chopped nuts(pecan) \n 1 cup miniature marshmallows \n 1. Mix all ingredients together and chill for serving.",
			"Ingredients \n ½ cup butter(soft) \n 2 eggs \n 1 cup white sugar \n 1 cup brown sugar \n 2 ½ cups white flour \n 1 cup oatmeal \n ¼ teaspoon baking soda \n ½ teaspoon cream of tartar \n 1 teaspoon vanilla \n 1 cup nuts or 1 cup raisins \n 1. Mix together the first four ingredients. \n 2. Mix together the flour, oatmeal, soda and cream of tartar. \n 3. Combine both with vanilla until well blended. \n 4. Add nuts or raisins, if desired. \n 5. Roll in balls and place on cookie sheets. \n 6. Bake for 10 minutes at 375 degrees. Makes 5 dozen.",
			"Ingredients \n 24 ounce can of jalapenos \n 24 ounce can of tomatoes (whole peeled) \n 3 tablespoons of basil \n 4 onions \n 3 tablespoons white pepper \n 3 tablespoons garlic powder \n 3 tablespoons salt \n cilantro and sugar as desired. \n 1. Mix in a food processor.",
			" 1.Peel and devein shrimp. \n 2. In a small bowl beat 1 or 2 eggs, 1 tablesppon parsley flakes, then to taste add garlic powder, meat tenderizer, season with salt and pepper. \n 3. Put the shrimp in this mixture and stir to mix. \n 4. Cover and put in the refrigerator for a couple of hours. \n 5. When ready to fry, put 1 cup of flour, 2 teaspoons of salt, some pepper and 2 tablespoons of baking powder, mix! \n 6. In a brown paper bag shake the shrimp in the flour mixture. \n 7. Drop in hot grease and fry until golden brown, about 1 minute or less. \n Do 12 -15 shrimp at a time.",
			"Ingredients \n 3 pounds ground chuck \n 1 pound hot bulk sausage \n 3 medium onions, chopped \n 4 cloves garlic(minced) \n ¼ cup chili powder \n 2 tablespoons all-purpose flour \n 1 ½ tablespoons sugar \n 1 tablespoon ground oregano \n 1 tablespoon salt \n 2 28-ounce cans whole tomatoes(undrained and choppend) \n 3 16-ounce cans kidney beans, drained \n 1. Combine ground chuck, sausage, onion and garlic in Dutch oven. \n 2. Cook until meat is browned, stir to crumble. Drain. \n 3. Stir in chili powder, flour, sugar, oregano, salt and tomatoes. \n 4. Cover and simmer 1 hour, stirring occasionally. \n 5. Add drained beans, simmer for an additional 20 minutes."
			};
	

	
	public String getRecipe(int pos){
		return recipes[pos];
	}
	
	public String getDirections(int pos){
		return directions[pos];
	}
	
	public String[] getRecipeList(){
		return recipes;
	}
	
	
}
