package com.japps.uilearningfinale;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;

import static android.content.pm.PackageManager.MATCH_DEFAULT_ONLY;

public class FirstInHelpActivity extends Fragment implements View.OnClickListener {

    private static final int CAPTURE_IMAGE_CODE = 12;

    public FirstInHelpActivity() {
    }

    public static FirstInHelpActivity newInstance() {
        return new FirstInHelpActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first_in_help_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView takeImageCard = view.findViewById(R.id.img_taking_card);
        takeImageCard.setOnClickListener(this);
    }

    private void intentTakePhoto() {

        File appDir = requireContext().getFilesDir();

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                .putExtra(MediaStore.EXTRA_OUTPUT, appDir.getAbsolutePath());
        Intent choose = Intent.createChooser(intent, "Capture photo with ");

        if (intentResolvable(intent))
            startActivity(intent);
        else
            toast("Unhandled action");

    }

    private void intentSendText(String msg) {
        Intent intent = new Intent(Intent.ACTION_SEND)
                .putExtra(Intent.EXTRA_TEXT, msg)
                .setType("text/plan");
        // force user to choose an app in an app chooser UI
        Log.e("Bundle ", "resolving activities\n " + requireActivity().getPackageManager().queryIntentActivities(intent, MATCH_DEFAULT_ONLY));

        Intent chooser = Intent.createChooser(intent, "Send text message with");

        if (intentResolvable(intent))
            startActivity(chooser);
        else
            toast("Unhandled action");
    }

    private boolean intentResolvable(Intent intent) {
        return intent.resolveActivity(requireActivity().getPackageManager()) != null;
    }

    private void intentStartTimer(String msg, int seconds) {

        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, msg)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);

        if (intent.resolveActivity(requireActivity().getPackageManager()) != null)
            startActivity(intent);
        else
            Toast.makeText(requireContext(), "Unhandled action", Toast.LENGTH_SHORT).show();
    }

    private void snackMessage(String msg) {
        Snackbar.make(requireView(), msg, Snackbar.LENGTH_SHORT).show();
    }

    private void toast(String text) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_taking_card)
            intentTakePhoto();
    }
}
