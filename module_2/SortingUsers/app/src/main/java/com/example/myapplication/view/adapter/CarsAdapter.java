package com.example.myapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.domain.Car;

import java.util.ArrayList;

public class CarsAdapter extends RecyclerView.Adapter<CarHolder> {
    ArrayList<Car> carsList;

    public CarsAdapter(ArrayList<Car> carsList) {
        this.carsList = carsList;
    }

    public ArrayList<Car> getCarsList() {
        return carsList;
    }

    public void updateAdapter(ArrayList<Car> cars) {
        this.carsList = cars;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.car_card, parent, false);

        return new CarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarHolder holder, int position) {
        Car car = carsList.get(position);
        holder.bind(car);
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }
}

class CarHolder extends RecyclerView.ViewHolder {

    TextView carName;
    TextView carModel;
    TextView carPower;
    TextView carVolume;
    TextView carMileage;

    public CarHolder(@NonNull View itemView) {
        super(itemView);
        carName = itemView.findViewById(R.id.carName);
        carModel = itemView.findViewById(R.id.carModel);
        carPower = itemView.findViewById(R.id.carPowerValue);
        carVolume = itemView.findViewById(R.id.carVolumeValue);
        carMileage = itemView.findViewById(R.id.carMileageValue);
    }

    public void bind(Car car) {
        carName.setText(car.name);
        carModel.setText(car.model);
        carPower.setText(String.valueOf(car.power));
        carVolume.setText(String.valueOf(car.volume));
        carMileage.setText(String.valueOf(car.mileage));
    }
}
