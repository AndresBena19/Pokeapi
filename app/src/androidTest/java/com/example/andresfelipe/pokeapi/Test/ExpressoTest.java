package com.example.andresfelipe.pokeapi.Test;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.andresfelipe.pokeapi.Factory.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.not;
import com.example.andresfelipe.pokeapi.R;

/**
 * Created by andres felipe on 07/10/2017.
 */




@RunWith(AndroidJUnit4.class)
public class ExpressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    //Comprobar que el boton de pelea esta deshabilidado siempre, al comienzo de la aplicacion.
    public void StateOfFightBotton(){

        onView(withId(R.id.button)).check(matches(not(isEnabled())));


    }





}
