package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CicularListImpl implements CircularList  {

    private List<Integer> list = new ArrayList<Integer>();
    private int index = - 1;

    private Optional<Integer> indexUpdateAndGetListElement(){

        if (this.isEmpty()){
            index = -1;
            return Optional.empty();
        }
        
        if (index >= list.size()){
            index = 0;
        }else if(index < 0){
            index = list.size() - 1;
        }
        return Optional.of(list.get(index));
        
    }


    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        index++;
        return indexUpdateAndGetListElement();
    }

    @Override
    public Optional<Integer> previous() {
        index--;
        return indexUpdateAndGetListElement();
    }

    @Override
    public void reset() {
        list.clear();
    }

}
