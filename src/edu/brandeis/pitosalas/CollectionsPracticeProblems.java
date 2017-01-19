package edu.brandeis.pitosalas;

import java.util.*;

public class CollectionsPracticeProblems {
  static List<String> myList = new LinkedList<String>();
  static private Map<String, String> myMap1 = new HashMap<String, String>();
  static private Map<String, String> myMap2 = new HashMap<String, String>();
  static private List<Integer> myList2 = new ArrayList<Integer>();
  static private Set<Integer> mySet = new HashSet<Integer>();
  static private ArrayList<String> swapList = new ArrayList<>();
  static private ArrayList<Integer> rangeList = new ArrayList<>();
  static private ArrayList<Integer> pairs1 = new ArrayList<>();
  static private ArrayList<Integer> pairs2 = new ArrayList<>();

  public static void main(String[] args) {
    prepareData();

    System.out.println("Before insert() myList = " + myList);
    insert(myList, "Bravo");
    System.out.println("After insert myList = " + myList);

    System.out.printf("%nIsUnique map1: %s, map2: %s%n", isUnique1(myMap1), isUnique1(myMap2));
    System.out.printf("IsUnique map1: %s, map2: %s%n", isUnique2(myMap1), isUnique2(myMap2));

    System.out.printf("%nCounts output: %s%n", counts(myList2, mySet));

    System.out.printf("%nBefore Swap of strings: %s", swapList);
    swapPairs(swapList);
    System.out.printf("%nAfter Swap of strings: %s%n", swapList);

    System.out.printf("%nInput rangeList: %s%n", rangeList);
    System.out.printf("Output from range(rangeList): %d", range(rangeList));

    System.out.printf("%n%npairs1 and pairs2, before call to swapPairs: %s %s", pairs1, pairs2);
    wrapHalf(pairs1);
    wrapHalf(pairs2);
    System.out.printf("%npairs1 and pairs2, after call to swapPairs: %s %s", pairs1, pairs2);

  }

  // Insert String into List<String> maintaining alphabetical order
  public static void insert(List<String> list, String val) {
    int index = 0;
    for (String s : list) {
      if (s.compareTo(val) >= 0) {
        list.add(index, val);
        break;
      }
      index++;
    }
  }

  // This is the "obvious" solution to the problem.

  public static boolean isUnique1(Map<String, String> map) {
    Set<String> values = new HashSet<String>();
    for (String value : map.values()) {
      if (values.contains(value)) {
        return false; // we found at least one duplicate
      } else {
        values.add(value);
      }
    }
    return true;
  }

  // This solution is almost too clever! But it works and is more efficient!

  public static boolean isUnique2(Map<String, String> map) {
    return (new HashSet<String>(map.values()).size() == map.values().size());
  }

  // Look at a list of integers, and a set of target numbers, and return a map
  // that
  // contains a count of the number of times each target number appeared in the
  // list

  public static Map<Integer, Integer> counts(List<Integer> list, Set<Integer> set) {
    Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    for (int value : list) {
      if (set.contains(value)) {
        if (counts.containsKey(value)) {
          counts.put(value, counts.get(value) + 1);
        } else {
          counts.put(value, 1);
        }
      }
    }
    return counts;
  }

  // Swap strings pairwise in List of Strings
  public static void swapPairs(ArrayList<String> list) {
    for (int i = 0; i < list.size() - 1; i += 2) {
      String temp = list.get(i);
      list.set(i, list.get(i + 1));
      list.set(i + 1, temp);
    }
  }

  // Compute the range between the largest and smallest integers in this list

  public static int range(ArrayList<Integer> list) {
    if (list.size() == 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (Integer i : list) {
      min = Math.min(min, i);
      max = Math.max(max, i);
    }
    return max - min + 1;
  }

  // Swap the first half of a list with the second half
  public static void wrapHalf(List<Integer> list) {
    int halfSize = (list.size() + 1) / 2;
    for (int i = 0; i < halfSize; i++) {
      // wrap around one element
      int element = list.remove(list.size() - 1);
      list.add(0, element);
    }
  }

  public static void prepareData() {
    myList.addAll(Arrays.asList("Alpha", "Beta", "Gamma"));

    myMap1.put("Marty", "Stepp");
    myMap1.put("Stuart", "Reges");
    myMap1.put("Jessica", "Miller");
    myMap1.put("Amanda", "Camp");
    myMap2.put("Marty", "Stepp");
    myMap2.put("Stuart", "Reges");
    myMap2.put("Jessica", "Miller");
    myMap2.put("Bruce", "Reges");

    myList2.addAll(Arrays.asList(4, -2, 3, 9, 4, 17, 5, 29, 14, 87, 4, -2, 100));
    mySet.addAll(Arrays.asList(-2, 4, 29));

    swapList.addAll(Arrays.asList("to", "be", "or", "not", "to", "be", "hamlet"));

    rangeList.addAll(Arrays.asList(18, 14, 29, 12, 7, 25));

    pairs1.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
    pairs2.addAll(Arrays.asList(5, 6, 7, 8, 9));

  }

}