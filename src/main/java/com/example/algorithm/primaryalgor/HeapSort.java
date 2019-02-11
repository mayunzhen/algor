package com.example.algorithm.primaryalgor;
//http://www.cnblogs.com/hapjin/p/4622681.html

//维护堆性质都是从上往下；
public class HeapSort {
    public void HeapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子
        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }
            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[child])
                break;
            // 把孩子结点的值赋给父结点
            array[parent] = array[child];
            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        array[parent] = temp;
    }
    public int[] heapSort(int[] list) {
        // 循环建立初始堆
        for (int i = (list.length-1) / 2; i >= 0; i--) {
            HeapAdjust(list, i, list.length);
        }
        //insert a node to the big heap
        list = addNode(list,10);
        list = addNode(list,11);
        list = addNode(list,12);
        printPart(list,0,list.length-1);


        // 进行n-1次循环，完成排序
        for (int i = list.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(list, 0, i);
            System.out.format("第 %d 趟: \t", list.length - i);
            printPart(list, 0, list.length - 1);
        }
        return list;
    }
    public static int[] addNode(int[] arr, int node){
        int[] tmp = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        tmp[arr.length] = node;
        int index = arr.length;
        int parent = (index-1)/2;
        while (node > tmp[parent] && index>=1){
            tmp[index] = tmp[parent];
            index = parent;
            parent = (index-1)/2;
        }
        tmp[index] = node;
        return tmp;
    }
    public static int[] addNodeToHeap(int[] arr, int node){
        int[] arrTmp = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            arrTmp[i] = arr[i];
        }
        int newIndex = arrTmp.length-1;//从最后一个元素开始逐渐向上与父结点比较
        int parentIndex = (newIndex-1) / 2;
        arrTmp[newIndex] = node;
        while (node > arrTmp[parentIndex] && newIndex >= 1){
            arrTmp[newIndex] = arrTmp[parentIndex];
            newIndex = parentIndex;
            parentIndex = (newIndex-1)/2;
        }
        arrTmp[newIndex] = node;
        return arrTmp;
    }
    // 打印序列
    public void printPart(int[] list, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // 初始化一个序列
        int[] array = {1, 3, 4, 5, 2, 6, 9, 7, 8, 0 };

        // 调用快速排序方法
        HeapSort heap = new HeapSort();
        System.out.print("排序前:\t");
        heap.printPart(array, 0, array.length - 1);
        int[] list = heap.heapSort(array);
        System.out.print("排序后:\t");
        heap.printPart(list, 0, list.length - 1);
    }

}