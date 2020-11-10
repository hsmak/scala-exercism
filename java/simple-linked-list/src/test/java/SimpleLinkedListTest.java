import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

public class SimpleLinkedListTest {

    @Test
    public void aNewListIsEmpty() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void canCreateFromArray() {
        Character[] values = new Character[]{'1', '2', '3'};
        SimpleLinkedList<Character> list = new SimpleLinkedList<Character>(values);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void popOnEmptyListWillThrow() {
        SimpleLinkedList<String> list = new SimpleLinkedList<String>();

        assertThrows(
                NoSuchElementException.class,
                list::pop);
    }

    @Test
    public void popReturnsLastAddedElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
        list.push(9);
        list.push(8);
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.pop()).isEqualTo(8);
        assertThat(list.pop()).isEqualTo(9);
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void reverseReversesList() {
        SimpleLinkedList<String> list = new SimpleLinkedList<String>();
        list.push("9");
        list.push("8");
        list.push("7");
        list.push("6");
        list.push("5");
        list.reverse();
        assertThat(list.pop()).isEqualTo("9");
        assertThat(list.pop()).isEqualTo("8");
        assertThat(list.pop()).isEqualTo("7");
        assertThat(list.pop()).isEqualTo("6");
        assertThat(list.pop()).isEqualTo("5");
    }

    @Test
    public void canReturnListAsArray() {
        SimpleLinkedList<Character> list = new SimpleLinkedList<Character>();
        list.push('9');
        list.push('8');
        list.push('7');
        list.push('6');
        list.push('5');
        Character[] expected = {'5', '6', '7', '8', '9'};
        assertArrayEquals(expected, list.asArray(Character.class));
    }

    @Test
    public void canReturnEmptyListAsEmptyArray() {
        SimpleLinkedList<Object> list = new SimpleLinkedList<Object>();
        Object[] expected = {};
        assertArrayEquals(expected, list.asArray(Object.class));
    }

}
