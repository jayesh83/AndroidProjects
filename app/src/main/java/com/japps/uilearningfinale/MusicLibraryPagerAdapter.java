package com.japps.uilearningfinale;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MusicLibraryPagerAdapter extends FragmentStateAdapter {

    public MusicLibraryPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new FragmentMusicLibraryFirst();
            case 1:
                return new FragmentMusicLibrarySecond();
            case 2:
                return new FragmentMusicLibraryThird();
            case 3:
                return new FragmentMusicLibraryFourth();
        }
        return new FragmentMusicLibraryDefaultFallback();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
