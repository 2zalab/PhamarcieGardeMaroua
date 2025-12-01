<?php

namespace Database\Seeders;

use App\Models\User;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\Hash;

class AdminUserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        // Vérifier si l'utilisateur admin existe déjà
        $adminEmail = 'touzaisaac@gmail.com';
        $existingAdmin = User::where('email', $adminEmail)->first();

        if ($existingAdmin) {
            // Mettre à jour l'utilisateur existant pour le rendre admin
            $existingAdmin->update([
                'is_admin' => true,
                'password' => Hash::make('touza237'),
            ]);
            $this->command->info('Utilisateur admin existant mis à jour : ' . $adminEmail);
        } else {
            // Créer un nouvel utilisateur admin
            User::create([
                'name' => 'Isaac Touza',
                'email' => $adminEmail,
                'password' => Hash::make('touza237'),
                'is_admin' => true,
                'is_subscribed' => false,
                'subscription_type' => 'FREE',
            ]);
            $this->command->info('Utilisateur admin créé : ' . $adminEmail);
        }
    }
}
