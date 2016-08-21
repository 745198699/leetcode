/**
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Insert_Interval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		for(int i=0;i<intervals.size();i++){
			int newStart = newInterval.start;
			int newEnd = newInterval.end;
			if(newEnd<intervals.get(i).start)
			{
				intervals.add(i,newInterval);
				return intervals;
			}else if(newStart>intervals.get(i).end){
				continue;
			}else{
				newInterval.start=Math.min(newStart,intervals.get(i).start);
				newInterval.end=Math.max(newEnd, intervals.get(i).end);
				intervals.remove(i);
				i--;
			}
		}
		intervals.add(newInterval);
		
		return intervals;
//		List<Interval> result = new ArrayList<Interval>();
//		for(int i=0;i<intervals.size();i++){
//			int newStart = newInterval.start;
//			int newEnd = newInterval.end;
//			Interval curInterval = intervals.get(i);
//			int curStart = curInterval.start;
//			int curEnd = curInterval.end;
//			if(newEnd<curStart){
//				result.add(newInterval);
//				for(int j=i;j<intervals.size();j++)
//					result.add(intervals.get(j));
//				return result;
//			}else if(newStart>curEnd){
//				result.add(curInterval);
//			}
//			else{
//				newInterval.start=Math.min(curStart, newStart);
//				newInterval.end=Math.max(curEnd, newEnd);
//			}
//		}
//		result.add(newInterval);
//		return result;
	}

	public static void main(String[] args) {
		Interval i1 = new Interval(1, 5);
		Interval i2 = new Interval(6, 8);
		Interval i3 = new Interval(5, 6);
		List<Interval> l = new ArrayList<Interval>();
		l.add(i1);
		l.add(i2);
		new Insert_Interval().insert(l, i3);
	}
	
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}