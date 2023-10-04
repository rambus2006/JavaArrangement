package _02_class;


// 학과의 학생들이 인기투표, 합쳐서 가장 많은 그룹은?

// 1: btn, 2: 블랙핑크, 3: 뉴진스, 4: 더보이즈, 5: 아이돌

class Solution002_1  {

    final int maxProductNumber = 5;

    public int[] func_a(int[] gr){

        int[] counter = new int[maxProductNumber + 1];

        for(int i = 0; i <gr.length; i++)

            counter[gr[i]] += 1;

        return counter;

    }

    public int solution(int[] web, int[] com) {

        int[] webCounter = func_a(web);

        int[] comCounter = func_a(com);

        int max_counter = 0;

        int max_group = 0;

        for(int i = 1; i <= maxProductNumber; i++)

        {

            int hap = webCounter[i] + comCounter[i];

            if (max_counter < hap ) {

                max_counter = hap;

                max_group = i;

            }

        }

        return max_group;

    }


// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.

    public static void main(String[] args) {

        Solution002_1 sol = new Solution002_1();

        int[] web = {1, 1, 1, 2, 4, 1, 4, 5, 3, 4};

        int[] com = {1, 2, 2, 4, 4, 5, 1, 2, 3, 4};

        int ret = sol.solution(web, com);

        String group_name ="" ;

// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        switch(ret)

        {

            case 1: group_name = "BTS"; break;

            case 2: group_name = "블랙핑크"; break;

            case 3: group_name = "뉴진스"; break;

            case 4: group_name = "더보이즈"; break;

            case 5: group_name = "아이들"; break;

        }

        System.out.println("반환 값: " + group_name + " 입니다.");

    }

}