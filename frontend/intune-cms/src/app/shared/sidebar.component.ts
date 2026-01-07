import { Component } from '@angular/core'
import { RouterModule } from '@angular/router';

@Component({
    selector: 'app-sidebar',
    imports: [RouterModule],
    standalone: true,
    templateUrl: './sidebar.component.html'
})

export class SidebarComponent {
    user = {
        name: "Guest User",
        avatar: "/icons/default-avatar.avif"
    }
    navigation = {
        home: "/icons/home-svgrepo-com.svg",
        projects: "/icons/folder-svgrepo-com.svg",
        releases: "/icons/record-svgrepo-com.svg",
        tracks: "/icons/audio-playlist-svgrepo-com.svg",
        content: "/icons/files-svgrepo-com.svg"
    }
}