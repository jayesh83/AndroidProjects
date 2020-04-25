package com.japps.uilearningfinale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MusicLibraryFragment extends Fragment {
    ViewPager2 pager2;
    TabLayout tabLayout;
    MusicLibraryPagerAdapter adapter;

    public MusicLibraryFragment() {
    }

    public static MusicLibraryFragment newInstance() {
        return new MusicLibraryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_music_library, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.music_library_tabLayout);
        pager2 = view.findViewById(R.id.music_library_viewPager);

        adapter = new MusicLibraryPagerAdapter(requireActivity());
        pager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("PLAYLISTS");
                        tab.setIcon(R.drawable.ic_playlist_play_24px);
                        break;
                    case 1:
                        tab.setText("ALBUMS");
                        tab.setIcon(R.drawable.ic_album_24px);
                        break;
                    case 2:
                        tab.setText("ARTISTS");
                        tab.setIcon(R.drawable.ic_record_voice_over_24px);
                        break;
                    case 3:
                        tab.setText("SONGS");
                        tab.setIcon(R.drawable.ic_songs_24px);
                        break;
                    default:
                        break;
                }
            }
        }).attach();

    }
}
