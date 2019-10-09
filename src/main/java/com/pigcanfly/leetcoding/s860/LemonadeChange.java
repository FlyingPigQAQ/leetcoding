package com.pigcanfly.leetcoding.s860;

/**
 * 当支付20美元的时候，优先扣一张10元和一个五元而不是3张五元
 * @author tobbyquinn
 * @date 2019/10/09
 */
public class LemonadeChange {
    /**
     * 代码精简
     * @param bills
     * @return
     */
    public boolean lemonadeChange1(int[] bills) {
        int five=0,ten=0;
        for (int bill:bills){
            if(bill==5){five++;}
            else if(bill==10){five--;ten++;}
            else if(ten>0){five--;ten--;}
            else {five-=3;}
            //先扣除，再检查
            if(five<0){
                return false;
            }
        }
        return true;
    }
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] > 5) {
            return false;
        }
        int[] changes = {0, 0, 0};
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    changes[0]++;
                    break;
                case 10:
                    if (changes[0] < 1) {
                        return false;
                    }
                    changes[1]++;
                    changes[0]--;
                    break;
                case 20:
                    if (changes[1] > 0) {
                        changes[1]--;
                        changes[0]--;
                    } else {
                        changes[0] -= 3;
                    }
                    if (changes[0] < 0) {
                        return false;
                    }
                    changes[2]++;
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
