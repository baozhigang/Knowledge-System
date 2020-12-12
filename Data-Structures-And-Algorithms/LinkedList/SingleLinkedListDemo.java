public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "松江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "无用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList sllist = new SingleLinkedList();
//        sllist.add(heroNode1);
//        sllist.add(heroNode2);
//        sllist.add(heroNode3);
//        sllist.add(heroNode4);

        sllist.addByOrder(heroNode1);
        sllist.addByOrder(heroNode3);
        sllist.addByOrder(heroNode2);
        sllist.addByOrder(heroNode4);
        sllist.addByOrder(heroNode3);

        sllist.list();

        sllist.update(new HeroNode(3, "无用吗", "智多星"));
        sllist.list();
    }
}
class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        // 先找到最后一个节点
        HeroNode temp = head;
        while(true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;  // 这里需要商榷
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if(temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("英雄已存在， 编号： %d\n", heroNode.no);
            return;
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("队列为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.println("节点未找到");
        }
    }

    // 展示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 重写方法
    public String toString() {
        return "HeroNode [no="+ no +" name="+ name +" nickname=" + nickname +"]";
    }
}
