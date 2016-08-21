/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Merge_Intervals {

	public static void main(String[] args) {
		List<Interval> l = new ArrayList<Interval>();
		l.add(new Interval(1,2));
		l.add(new Interval(3,4));
		l.add(new Interval(1,4));
		new Merge_Intervals().merge(l);
	}

	public List<Interval> merge(List<Interval> intervals) {

		if(intervals.size()==0)
			return intervals;
		
		//sort the intervals by the start
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				Interval i1=(Interval)o1;
				Interval i2=(Interval)o2;
				return Integer.compare(i1.start, i2.start);
			}
		});
		
		List<Interval> re = new LinkedList<Interval>();
		re.add(intervals.get(0));
		for(int i=1;i<intervals.size();i++){
			Interval cur_interval = intervals.get(i);
			int cur_start=cur_interval.start;
			int cur_end=cur_interval.end;
			int pre_len = re.size();
			boolean hasAdd=false;
			for(int j=0;j<pre_len;j++){
				Interval pre_interval = re.get(j);
				int pre_start = pre_interval.start;
				int pre_end = pre_interval.end;
				if(cur_start>pre_end)
					continue;
				else{
					pre_interval.end=(cur_end>=pre_end?cur_end:pre_end);
					hasAdd=true;
					break;
				}
			}
			if(!hasAdd)
				re.add(cur_interval);
		}
		
		return re; 
	}

}
//class Interval {
//	int start;
//	int end;
//	Interval() { start = 0; end = 0; }
//	Interval(int s, int e) { start = s; end = e; }
//}
