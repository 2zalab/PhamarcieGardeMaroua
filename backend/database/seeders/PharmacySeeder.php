<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\Pharmacy;
use App\Models\Schedule;
use Carbon\Carbon;

class PharmacySeeder extends Seeder
{
    public function run(): void
    {
        $pharmacies = [
            [
                'name' => 'Pharmacie du Centre',
                'address' => 'Avenue de la Réunification, Centre-ville',
                'phone' => '+237 699 123 456',
                'phone_secondary' => '+237 677 123 456',
                'latitude' => 10.5905,
                'longitude' => 14.3159,
                'district' => 'Centre-ville',
                'description' => 'Pharmacie moderne au cœur de Maroua avec un personnel qualifié et des médicaments de qualité.',
                'has_parking' => true,
                'has_wheelchair_access' => true,
                'is_24_hours' => false,
            ],
            [
                'name' => 'Pharmacie de la Paix',
                'address' => 'Quartier Domayo, Route de Mokolo',
                'phone' => '+237 698 234 567',
                'phone_secondary' => '+237 676 234 567',
                'latitude' => 10.6015,
                'longitude' => 14.3245,
                'district' => 'Domayo',
                'description' => 'Pharmacie de quartier offrant un service de qualité et des conseils personnalisés.',
                'has_parking' => true,
                'has_wheelchair_access' => false,
                'is_24_hours' => false,
            ],
            [
                'name' => 'Pharmacie de l\'Espoir',
                'address' => 'Quartier Dougoy, près du marché',
                'phone' => '+237 697 345 678',
                'phone_secondary' => null,
                'latitude' => 10.5825,
                'longitude' => 14.3089,
                'district' => 'Dougoy',
                'description' => 'Pharmacie accessible avec un large choix de médicaments génériques.',
                'has_parking' => false,
                'has_wheelchair_access' => false,
                'is_24_hours' => false,
            ],
            [
                'name' => 'Pharmacie du Nord',
                'address' => 'Quartier Pitoaré, Route de Kousséri',
                'phone' => '+237 696 456 789',
                'phone_secondary' => '+237 675 456 789',
                'latitude' => 10.6125,
                'longitude' => 14.3298,
                'district' => 'Pitoaré',
                'description' => 'Grande pharmacie moderne avec service de garde 24h/24.',
                'has_parking' => true,
                'has_wheelchair_access' => true,
                'is_24_hours' => true,
            ],
            [
                'name' => 'Pharmacie Sainte Marie',
                'address' => 'Quartier Hardé, Avenue des Martyrs',
                'phone' => '+237 695 567 890',
                'phone_secondary' => '+237 674 567 890',
                'latitude' => 10.5745,
                'longitude' => 14.3025,
                'district' => 'Hardé',
                'description' => 'Pharmacie de confiance avec service de livraison à domicile.',
                'has_parking' => false,
                'has_wheelchair_access' => true,
                'is_24_hours' => false,
            ],
            [
                'name' => 'Pharmacie Nouvelle Génération',
                'address' => 'Quartier Founangué, Route de Garoua',
                'phone' => '+237 694 678 901',
                'phone_secondary' => null,
                'latitude' => 10.5655,
                'longitude' => 14.2963,
                'district' => 'Founangué',
                'description' => 'Pharmacie équipée des dernières technologies pour vous servir.',
                'has_parking' => true,
                'has_wheelchair_access' => false,
                'is_24_hours' => false,
            ],
            [
                'name' => 'Pharmacie du Sahel',
                'address' => 'Quartier Bamaré, près de la Gendarmerie',
                'phone' => '+237 693 789 012',
                'phone_secondary' => '+237 673 789 012',
                'latitude' => 10.6035,
                'longitude' => 14.3412,
                'district' => 'Bamaré',
                'description' => 'Pharmacie spécialisée dans les produits de parapharmacie.',
                'has_parking' => true,
                'has_wheelchair_access' => true,
                'is_24_hours' => false,
            ],
            [
                'name' => 'Pharmacie des Fleurs',
                'address' => 'Quartier Maroua-Domayo, Avenue du Mandara',
                'phone' => '+237 692 890 123',
                'phone_secondary' => null,
                'latitude' => 10.5965,
                'longitude' => 14.3189,
                'district' => 'Domayo',
                'description' => 'Pharmacie accueillante avec un personnel souriant et compétent.',
                'has_parking' => false,
                'has_wheelchair_access' => false,
                'is_24_hours' => false,
            ],
        ];

        foreach ($pharmacies as $index => $pharmacyData) {
            $pharmacy = Pharmacy::create($pharmacyData);

            $startDate = Carbon::now()->subDays(2);

            for ($i = 0; $i < 6; $i++) {
                $scheduleStartDate = $startDate->copy()->addDays($i * 7);
                $scheduleEndDate = $scheduleStartDate->copy()->addDays(6);

                Schedule::create([
                    'pharmacy_id' => $pharmacy->id,
                    'start_date' => $scheduleStartDate,
                    'end_date' => $scheduleEndDate,
                    'start_time' => '08:00:00',
                    'end_time' => $pharmacy->is_24_hours ? null : '22:00:00',
                    'is_on_duty' => (($index + $i) % count($pharmacies)) == 0,
                    'notes' => 'Garde hebdomadaire',
                ]);
            }
        }
    }
}
