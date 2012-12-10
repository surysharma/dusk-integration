package com.hedgebenefits.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**


 **/
public class ConversationalTimeTest {

    private ConversationalTime1 conversationalTime = new ConversationalTime1();


    @Test
    public void shouldGiveMidnightFor00_00() {
        //When

        //Then
        assertThat(conversationalTime.getNewConversationalTime("00:35"), is("twenty five to one"));

        assertThat(conversationalTime.getNewConversationalTime("07:35"), is("twenty five to eight"));
        assertThat(conversationalTime.getNewConversationalTime("08:36"), is("just after twenty five to nine"));
        assertThat(conversationalTime.getNewConversationalTime("09:37"), is("just after twenty five to ten"));
        assertThat(conversationalTime.getNewConversationalTime("10:38"), is("almost twenty to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:39"), is("almost twenty to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:40"), is("twenty to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:41"), is("just after twenty to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:42"), is("just after twenty to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:43"), is("almost quarter to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:44"), is("almost quarter to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:45"), is("quarter to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:46"), is("just after quarter to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:47"), is("just after quarter to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:48"), is("almost ten to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:49"), is("almost ten to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:50"), is("ten to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:51"), is("just after ten to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:52"), is("just after ten to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:53"), is("almost five to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:54"), is("almost five to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:55"), is("five to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:56"), is("just after five to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:57"), is("just after five to eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:58"), is("almost eleven"));
        assertThat(conversationalTime.getNewConversationalTime("10:59"), is("almost eleven"));
        assertThat(conversationalTime.getNewConversationalTime("11:00"), is("eleven"));

        assertThat(conversationalTime.getNewConversationalTime("11:58"), is("almost noon"));
        assertThat(conversationalTime.getNewConversationalTime("14:10"), is("ten past two"));
        assertThat(conversationalTime.getNewConversationalTime("14:58"), is("almost three"));

        assertThat(conversationalTime.getNewConversationalTime("10:00"), is("ten"));
        assertThat(conversationalTime.getNewConversationalTime("10:13"), is("almost quarter past ten"));
        assertThat(conversationalTime.getNewConversationalTime("10:15"), is("quarter past ten"));
        assertThat(conversationalTime.getNewConversationalTime("10:16"), is("just after quarter past ten"));
        assertThat(conversationalTime.getNewConversationalTime("10:18"), is("almost twenty past ten"));
        assertThat(conversationalTime.getNewConversationalTime("10:20"), is("twenty past ten"));


    }
}
