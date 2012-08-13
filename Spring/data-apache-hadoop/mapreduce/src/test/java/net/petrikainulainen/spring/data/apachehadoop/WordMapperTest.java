package net.petrikainulainen.spring.data.apachehadoop;

import net.petrikainulainen.spring.data.apachehadoop.WordMapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Petri Kainulainen
 */
public class WordMapperTest {

    private Mapper.Context contextMock;

    private WordMapper mapper;

    @Before
    public void setUp() {
        contextMock =  mock(Mapper.Context.class);
        mapper = new WordMapper();
    }

    @Test
    public void MapEmpty() throws IOException, InterruptedException {
        LongWritable key = new LongWritable(1);

        mapper.map(key, new Text(""), contextMock);

        verifyZeroInteractions(contextMock);
    }


    @Test
    public void MapWithApostrophe() throws IOException, InterruptedException {
        LongWritable key = new LongWritable(1);

        mapper.map(key, new Text("I'"), contextMock);

        ArgumentCaptor<Text> keyArgument = ArgumentCaptor.forClass(Text.class);
        ArgumentCaptor<IntWritable> valueArgument = ArgumentCaptor.forClass(IntWritable.class);

        verify(contextMock, times(1)).write(keyArgument.capture(), valueArgument.capture());
        assertEquals("I", keyArgument.getValue().toString());
        assertEquals(1, valueArgument.getValue().get());

        verifyNoMoreInteractions(contextMock);
    }

    @Test
    public void mapWithComma() throws IOException, InterruptedException {
        LongWritable key = new LongWritable(1);

        mapper.map(key, new Text("I,"), contextMock);

        ArgumentCaptor<Text> keyArgument = ArgumentCaptor.forClass(Text.class);
        ArgumentCaptor<IntWritable> valueArgument = ArgumentCaptor.forClass(IntWritable.class);

        verify(contextMock, times(1)).write(keyArgument.capture(), valueArgument.capture());
        assertEquals("I", keyArgument.getValue().toString());
        assertEquals(1, valueArgument.getValue().get());

        verifyNoMoreInteractions(contextMock);
    }

    @Test
    public void mapWithDot() throws IOException, InterruptedException {
        LongWritable key = new LongWritable(1);

        mapper.map(key, new Text("I."), contextMock);

        ArgumentCaptor<Text> keyArgument = ArgumentCaptor.forClass(Text.class);
        ArgumentCaptor<IntWritable> valueArgument = ArgumentCaptor.forClass(IntWritable.class);

        verify(contextMock, times(1)).write(keyArgument.capture(), valueArgument.capture());
        assertEquals("I", keyArgument.getValue().toString());
        assertEquals(1, valueArgument.getValue().get());

        verifyNoMoreInteractions(contextMock);
    }

    @Test
    public void mapWithDoubleLine() throws IOException, InterruptedException {
        LongWritable key = new LongWritable(1);

        mapper.map(key, new Text("I--"), contextMock);

        ArgumentCaptor<Text> keyArgument = ArgumentCaptor.forClass(Text.class);
        ArgumentCaptor<IntWritable> valueArgument = ArgumentCaptor.forClass(IntWritable.class);

        verify(contextMock, times(1)).write(keyArgument.capture(), valueArgument.capture());
        assertEquals("I", keyArgument.getValue().toString());
        assertEquals(1, valueArgument.getValue().get());

        verifyNoMoreInteractions(contextMock);
    }

    @Test
    public void mapWithExclamationMark() throws IOException, InterruptedException {
        LongWritable key = new LongWritable(1);

        mapper.map(key, new Text("I!"), contextMock);

        ArgumentCaptor<Text> keyArgument = ArgumentCaptor.forClass(Text.class);
        ArgumentCaptor<IntWritable> valueArgument = ArgumentCaptor.forClass(IntWritable.class);

        verify(contextMock, times(1)).write(keyArgument.capture(), valueArgument.capture());
        assertEquals("I", keyArgument.getValue().toString());
        assertEquals(1, valueArgument.getValue().get());

        verifyNoMoreInteractions(contextMock);
    }

    @Test
    public void mapWithQuestionMark() throws IOException, InterruptedException {
        LongWritable key = new LongWritable(1);

        mapper.map(key, new Text("I?"), contextMock);

        ArgumentCaptor<Text> keyArgument = ArgumentCaptor.forClass(Text.class);
        ArgumentCaptor<IntWritable> valueArgument = ArgumentCaptor.forClass(IntWritable.class);

        verify(contextMock, times(1)).write(keyArgument.capture(), valueArgument.capture());
        assertEquals("I", keyArgument.getValue().toString());
        assertEquals(1, valueArgument.getValue().get());

        verifyNoMoreInteractions(contextMock);
    }

    @Test
    public void mapWithQuationMark() throws IOException, InterruptedException {
        LongWritable key = new LongWritable(1);

        mapper.map(key, new Text("\"I"), contextMock);

        ArgumentCaptor<Text> wordArgument = ArgumentCaptor.forClass(Text.class);
        ArgumentCaptor<IntWritable> valueArgument = ArgumentCaptor.forClass(IntWritable.class);

        verify(contextMock, times(1)).write(wordArgument.capture(), valueArgument.capture());
        assertEquals("I", wordArgument.getValue().toString());
        assertEquals(1, valueArgument.getValue().get());

        verifyNoMoreInteractions(contextMock);
    }
}
