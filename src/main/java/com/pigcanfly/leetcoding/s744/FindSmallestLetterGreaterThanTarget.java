package com.pigcanfly.leetcoding.s744;

/**
 * @author tobbyquinn
 * @date 2019/11/20
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        char smallThanTarget=255,greaterThanTarget=255;
        for (char letter : letters) {
            if(letter<target){
                smallThanTarget=letter<smallThanTarget?letter:smallThanTarget;
            }else if(letter>target){
                greaterThanTarget= letter<greaterThanTarget?letter:greaterThanTarget;
            }
        }
        return greaterThanTarget!=255?greaterThanTarget:smallThanTarget;
    }

    public static void main(String[] args) {
        new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c','f','j'}, 'a');
    }
}
