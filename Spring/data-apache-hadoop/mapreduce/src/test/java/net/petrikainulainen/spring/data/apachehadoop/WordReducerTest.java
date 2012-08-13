package net.petrikainulainen.spring.data.apachehadoop;

import net.petrikainulainen.spring.data.apachehadoop.WordReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * @author Petri Kainulainen
 */
public class WordReducerTest {

    private static final String NOT_TARGET_WORD = "foobar";

    private Reducer.Context contextMock;

    private WordReducer reducer;

    @Before
    public void setUp() {
        contextMock = mock(Reducer.Context.class);
        reducer = new WordReducer();
    }

    @Test
    public void reduceWhenTargetWordIsFound() throws IOException, InterruptedException {
        Text key = new Text(WordReducer.TARGET_WORD);
        Iterable<IntWritable> values = createValues(1, 1, 1);
        reducer.reduce(key, values, contextMock);

        ArgumentCaptor<IntWritable> countArgument = ArgumentCaptor.forClass(IntWritable.class);

        verify(contextMock, times(1)).write(eq(key), countArgument.capture());
        verifyNoMoreInteractions(contextMock);

        IntWritable count = countArgument.getValue();
        assertEquals(3, count.get());
    }

    @Test
    public void reduceWhenTargetWordIsNotFound() throws IOException, InterruptedException {
        Text key = new Text(NOT_TARGET_WORD);
        Iterable<IntWritable> values = createValues(1, 1, 1);
        reducer.reduce(key, values, contextMock);

        verifyZeroInteractions(contextMock);
    }

    private Iterable<IntWritable> createValues(int ... values) {
        ArrayList<IntWritable> list = new ArrayList<IntWritable>();

        for (int value: values) {
            list.add(new IntWritable(value));
        }

        return list;
    }
}
