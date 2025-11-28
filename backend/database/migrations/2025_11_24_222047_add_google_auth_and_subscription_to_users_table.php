<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::table('users', function (Blueprint $table) {
            // Google OAuth
            $table->string('google_id')->unique()->nullable()->after('id');
            $table->string('avatar')->nullable()->after('email');

            // Subscription fields
            $table->boolean('is_subscribed')->default(false)->after('avatar');
            $table->enum('subscription_type', ['FREE', 'MONTHLY', 'ANNUAL'])->default('FREE')->after('is_subscribed');
            $table->timestamp('subscription_expires_at')->nullable()->after('subscription_type');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('users', function (Blueprint $table) {
            $table->dropColumn([
                'google_id',
                'avatar',
                'is_subscribed',
                'subscription_type',
                'subscription_expires_at'
            ]);
        });
    }
};
