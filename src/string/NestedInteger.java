package string;

import java.util.ArrayList;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public class NestedInteger {
	private int value = Integer.MAX_VALUE;
	private List<NestedInteger>list = new ArrayList<NestedInteger>();
	
    // Constructor initializes an empty nested list.
    public NestedInteger(){
    	
    };

    // Constructor initializes a single integer.
    public NestedInteger(int value){
    	this.value = value;
    };

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){
    	return value==Integer.MAX_VALUE?false:true;
    };

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){
    	return value;
    };

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){
    	this.value = value;
    };

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){
    	list.add(ni);
    };

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){
    	return list;
    };
}