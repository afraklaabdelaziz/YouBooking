import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-satatistic',
  templateUrl: './satatistic.component.html',
  styleUrls: ['./satatistic.component.css']
})
export class SatatisticComponent {

  @Input()
  get statSubtitle(): string {
    return this._statSubtitle;
  }
  set statSubtitle(statSubtitle: string) {
    this._statSubtitle  = statSubtitle;
  }
  private _statSubtitle = "Traffic";

  @Input()
  get statTitle(): string {
    return this._statTitle;
  }
  set statTitle(statTitle: string) {
    this._statTitle =  statTitle;
  }
  private _statTitle = "350,897";

  // The value must match one of up or down


  @Input()
  get statIconName(): string {
    return this._statIconName;
  }
  set statIconName(statIconName: string) {
    this._statIconName =
      statIconName = statIconName;
  }
  private _statIconName = "far fa-chart-bar";

  // can be any of the background color utilities
  // from tailwindcss
  @Input()
  get statIconColor(): string {
    return this._statIconColor;
  }
  set statIconColor(statIconColor: string) {
    this._statIconColor =
      statIconColor = statIconColor;
  }
  private _statIconColor = "bg-red-500";

  constructor() {}

  ngOnInit(): void {}

}
