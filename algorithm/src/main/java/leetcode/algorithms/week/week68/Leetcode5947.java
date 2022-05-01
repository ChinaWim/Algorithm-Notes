package leetcode.algorithms.week.week68;

import java.util.*;

/**
 * 你有 n 道不同菜的信息。给你一个字符串数组 recipes 和一个二维字符串数组 ingredients 。第 i 道菜的名字为 recipes[i] ，如果你有它 所有 的原材料 ingredients[i] ，那么你可以 做出 这道菜。一道菜的原材料可能是 另一道 菜，也就是说 ingredients[i] 可能包含 recipes 中另一个字符串。
 *
 * 同时给你一个字符串数组 supplies ，它包含你初始时拥有的所有原材料，每一种原材料你都有无限多。
 *
 * 请你返回你可以做出的所有菜。你可以以 任意顺序 返回它们。
 *
 * 注意两道菜在它们的原材料中可能互相包含。
 */
public class Leetcode5947 {


    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        //init
        HashSet<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        ArrayList<String> recipesList = new ArrayList<>(Arrays.asList(recipes));
        while(true){
            boolean addFlag = false;
            for (int i = 0; i < recipesList.size(); i++) {
                String recipesData = recipesList.get(i);
                if (recipesData.equals("")) {
                    continue;
                }
                List<String> ingredient = ingredients.get(i);
                boolean has = true;
                for (String ig : ingredient) {
                    if (!suppliesSet.contains(ig)) {
                        has = false;
                        break;
                    }
                }
                if (has) {
                    addFlag = true;
                    result.add(recipesData);
                    suppliesSet.add(recipesData);
                    recipesList.set(i, "");
                }
            }
            if(!addFlag){
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
